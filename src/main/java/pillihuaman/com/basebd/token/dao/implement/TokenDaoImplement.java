package pillihuaman.com.basebd.token.dao.implement;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pillihuaman.com.basebd.config.AbstractMongoRepositoryImpl;
import pillihuaman.com.basebd.help.Constants;
import pillihuaman.com.basebd.token.Token;
import pillihuaman.com.basebd.token.dao.TokenRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TokenDaoImplement extends AbstractMongoRepositoryImpl<Token> implements TokenRepository {
    public TokenDaoImplement() {
        DS_WRITE = Constants.DW;
        // DS_READ = Constants.DR;
        COLLECTION = Constants.COLLECTION_TOKEN;

    }

    @Override
    public Class<Token> provideEntityClass() {
        // TODO Auto-generated method stub
        return Token.class;
    }


    @Override
    public List<Token> findAllValidTokenByUser(Object id) {
        MongoCollection<Token> collection = getCollection(this.collectionName, Token.class);
        //Document query = new Document().append("_id", id);
        //Created with NoSQLBooster, the essential IDE for MongoDB - https://nosqlbooster.com
        Document query = new Document()
                .append("user._id", id);
        List<Token> lsiTok = collection.find(query, Token.class).limit(1).into(new ArrayList<Token>());
        return lsiTok;
    }

    @Override
    public Optional<Token> findByToken(String token) {
        MongoCollection<Token> collection = getCollection(this.collectionName, Token.class);
        Document query = new Document().append("_id", token);

        Token toke = collection.find(query, Token.class).limit(1).first();
        return Optional.ofNullable(toke);
    }
}
