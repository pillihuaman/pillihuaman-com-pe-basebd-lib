package pillihuaman.com.basebd.user.dao.implement;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;
import pillihuaman.com.basebd.config.AbstractMongoRepositoryImpl;
import pillihuaman.com.basebd.token.dao.implement.CustomUserDetailsServiceImpl;
import pillihuaman.com.basebd.help.AuditEntity;
import pillihuaman.com.basebd.help.Constants;
import pillihuaman.com.basebd.user.User;
import pillihuaman.com.basebd.user.dao.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class UserDaoImplement extends AbstractMongoRepositoryImpl<User> implements UserRepository {

    @Autowired
    private CustomUserDetailsServiceImpl customUserDetailsServiceImpl;

    UserDaoImplement() {
        DS_WRITE = Constants.DW;
        // DS_READ = Constants.DR;
        COLLECTION = Constants.COLLECTION_USER;
    }

    @Override
    public Optional<UserDetailsService> findByEmail(String mail) {
        Optional<UserDetailsService> op = null;
        MongoCollection<User> collection = getCollection(this.collectionName, User.class);
        Document query = new Document().append("mail", mail);
        User user = collection.find(query, User.class).limit(1).first();
        if (user != null) {
            // Convert User to UserDetailsService (you need to implement this conversion)
            UserDetails userDetails = customUserDetailsServiceImpl.convertUserToUserDetailsService(user);
            return Optional.of((UserDetailsService) userDetails);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<User> findUserByMail(String mail) {
        MongoCollection<User> collection = getCollection(this.collectionName, User.class);
        Document query = new Document("mail", mail);

        List<User> lisUser = new ArrayList<>();

        try {
            FindIterable<User> results = collection.find(query, User.class);
            for (User user : results) {
                lisUser.add(user);
            }
        } catch (Exception e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            e.printStackTrace();
        }

        return lisUser;
    }

    @Override
    public List<User> findUserName(String username) {
        MongoCollection<User> collection = getCollection(this.collectionName, User.class);
        Document query = new Document().append("username", username);
        List<User> lisUser = collection.find(query, User.class).limit(1).into(new ArrayList<User>());

        return lisUser;
    }

    @Override
    public Class<User> provideEntityClass() {
        // TODO Auto-generated method stub
        return User.class;
    }

    @Override
    public boolean saveUser(User request) {

        try {
            Document doc = new Document();
            Document docAud = new Document();
            AuditEntity aud = new AuditEntity();

            request.setAuditEntity(aud);
            doc.put("alias", request.getAlias());
            doc.put("api_password", request.getApi_password());
            doc.put("id_system", request.getId_system());
            doc.put("mail", request.getEmail());
            doc.put("mobil_phone", request.getMobil_phone());
            doc.put("password", request.getPassword());
            doc.put("sal_password", request.getSal_password());
            doc.put("user_name", request.getUsername());
            doc.put("type_document", request.getType_document());
            doc.put("numType_document", request.getNumType_document());
            doc.put("id_user", null);
            doc.put("auditEntity", docAud);
            save(doc);
        } catch (Exception e) {
            // Handle the exception (e.g., log it or throw a custom exception)
            e.printStackTrace();
        }


        return true;
    }

    @Override
    public List<User> findLastUser() {
        MongoCollection<User> collection = getCollection(this.collectionName, User.class);
        Document query = new Document();
        Document sort = new Document().append("id_user", -1);
        List<User> lisProduct = collection.find(query, User.class).sort(sort).limit(1).into(new ArrayList<User>());
        return lisProduct;
    }

    @Override
    public List<User> findUserById(ObjectId id) {
        MongoCollection<User> collection = getCollection(this.collectionName, User.class);
        Document query = new Document().append("_id", id);
        List<User> lisUser = collection.find(query, User.class).limit(1).into(new ArrayList<User>());
        return lisUser;
    }

}
