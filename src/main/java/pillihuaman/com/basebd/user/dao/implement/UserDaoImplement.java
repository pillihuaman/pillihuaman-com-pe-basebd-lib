package pillihuaman.com.basebd.user.dao.implement;

import com.mongodb.MongoException;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pillihuaman.com.basebd.config.AbstractMongoRepositoryImpl;
import pillihuaman.com.basebd.token.dao.TokenRepository;
import pillihuaman.com.basebd.help.AuditEntity;
import pillihuaman.com.basebd.help.Constants;
import pillihuaman.com.basebd.user.User;
import pillihuaman.com.basebd.user.dao.UserRepository;
import pillihuaman.com.lib.commons.MyJsonWebToken;

import java.util.*;


@Component
public class UserDaoImplement extends AbstractMongoRepositoryImpl<User> implements UserRepository {


    @Autowired
    private TokenRepository tokenRepository;


    UserDaoImplement() {
        DS_WRITE = Constants.DW;
        // DS_READ = Constants.DR;
        COLLECTION = "";
        COLLECTION = Constants.COLLECTION_USER;
    }


    @Override
    public Optional<User> findByEmail(String mail) {
        Optional<UserDetails> op = null;
        MongoCollection<User> collection = getCollection( Constants.COLLECTION_USER, User.class);
        Document query = new Document().append("email", mail);
        User user = collection.find(query, User.class).limit(1).first();
        user.setPassword(user.getPasswordP());
        user.setTokens(tokenRepository.findAllValidTokenByUser(user.getId()));
        if (user != null) {
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public int getLastIdUser() {
        int id = 0;
        try {
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase database = mongoClient.getDatabase(DS_WRITE);
            MongoCollection<Document> collection = database.getCollection( Constants.COLLECTION_USER);
            Document sort = new Document().append("_id", -1);
            Document lis = collection.find().sort(sort).first();
            if (Objects.nonNull(lis)) {
                id = (int) lis.get("idUser");
            }
            mongoClient.close();
        } catch (MongoException e) {
            id = 0;
        }
        return id;
    }

    @Override
    public List<User> findUserByMail(String mail) {
        try {
            Document query = new Document()
                    .append("mail", mail);
            Document sort = new Document()
                    .append("_id", -1);
            Optional<User> f = findAllByQuery(query).stream().findFirst();
            List<User> l = findAll();
        } catch (MongoException e) {
            throw e;
        }
        return null;
    }


    @Override
    public List<User> findUserName(String username) {
        MongoCollection<User> collection = getCollection( Constants.COLLECTION_USER, User.class);
        Document query = new Document().append("email", username);
        List<User> lisUser = collection.find(query, User.class).limit(1).into(new ArrayList<User>());

        return lisUser;
    }

    @Override
    public Class<User> provideEntityClass() {
        // TODO Auto-generated method stub
        return User.class;
    }

    @Override
    public User saveUser(User request, MyJsonWebToken jwt) {
        User us = null;
        try {
            Document doc = new Document();
            Document docAud = new Document();
            AuditEntity aud = new AuditEntity();
            aud.setDateRegister(new Date());
            aud.setMail(request.getEmail());
            // aud.setCodUser(jwt.getUser().getIdUser());
            // aud.setMail(jwt.getUser().getMail());
            //request.setAuditEntity(aud);
            doc.put("alias", request.getAlias());
            doc.put("apiPassword", request.getApiPassword());
            doc.put("idSystem", request.getIdSystem());
            doc.put("mail", request.getEmail());
            doc.put("mobilPhone", request.getMobilPhone());
            doc.put("password", request.getPassword());
            doc.put("salPassword", request.getSalPassword());
            //doc.put("userName", request.getUsername());
            doc.put("typeDocument", request.getTypeDocument());
            doc.put("numTypeDocument", request.getNumTypeDocument());
            doc.put("idUser", null);
            doc.put("auditEntity", docAud);
            request.setAuditEntity(aud);
            //save(doc);
            us = save(request);
        } catch (Exception e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            e.printStackTrace();
        }
        return us;
    }

    @Override
    public List<User> findLastUser() {
        MongoCollection<User> collection = getCollection( Constants.COLLECTION_USER, User.class);
        Document query = new Document();
        Document sort = new Document().append("id_user", -1);
        List<User> lisProduct = collection.find(query, User.class).sort(sort).limit(1).into(new ArrayList<User>());
        return lisProduct;
    }

    @Override
    public List<User> findUserById(ObjectId id) {
        MongoCollection<User> collection = getCollection( Constants.COLLECTION_USER, User.class);
        Document query = new Document().append("_id", id);
        List<User> lisUser = collection.find(query, User.class).limit(1).into(new ArrayList<User>());
        return lisUser;
    }


    public UserDetails convertUserToUserDetailsService(User user) {
        // Create a UserDetails object using Spring Security's User class
        UserDetails userDetails = User.builder()
                .userName(user.getUsername())
                .password(user.getPasswordP())
                .email(user.getEmail())
                .build();

        return userDetails;
    }
}
