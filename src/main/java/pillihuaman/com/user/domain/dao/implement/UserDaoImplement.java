package pillihuaman.com.user.domain.dao.implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Component;

import com.mongodb.client.MongoCollection;

import pillihuaman.com.config.AbstractMongoDBRepositoryImpl;
import pillihuaman.com.help.AuditEntity;
import pillihuaman.com.help.Constants;
import pillihuaman.com.user.domain.User;
import pillihuaman.com.user.domain.dao.UserRepository;
@Component
public class UserDaoImplement extends AbstractMongoDBRepositoryImpl<User> implements UserRepository {
	UserDaoImplement() {
		DS_WRITE = Constants.DW;
		// DS_READ = Constants.DR;
		COLLECTION = Constants.COLLECTION_USER;
	}

	@Override
	public List<User> findUserByMail(String mail) {
		MongoCollection<User> collection = getCollection(this.collectionName, User.class);
		Document query = new Document().append("mail", mail);
		List<User> lisUser = collection.find(query, User.class).limit(1).into(new ArrayList<User>());
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
		Document doc = new Document();
		Document docAud = new Document();
		AuditEntity aud = new AuditEntity();
		aud.setCodUsuRegis("ZPH");
		aud.setFecRegis(new Date());
		request.setAuditEntity(aud);

		doc.put("alias", request.getAlias());
		doc.put("api_password", request.getApi_password());
		doc.put("id_system", request.getId_system());
		doc.put("mail", request.getMail());
		doc.put("mobil_phone", request.getMobil_phone());
		doc.put("password", request.getPassword());
		doc.put("sal_password", request.getSal_password());
		doc.put("user_name", request.getUser_name());
		doc.put("type_document", request.getType_document());
		doc.put("numType_document", request.getNumType_document());
		doc.put("id_user", request.getId_user());

		docAud.put("cod_usuRegis", aud.getCodUsuRegis());
		docAud.put("fec_regis", aud.getFecRegis());

		doc.put("auditEntity", docAud);

		save(doc);
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

}
