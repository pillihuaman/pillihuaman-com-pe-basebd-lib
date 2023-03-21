package pillihuaman.com.basebd.user.domain.dao;

import java.util.List;

import org.bson.types.ObjectId;
import pillihuaman.com.basebd.config.BaseMongoRepository;
import pillihuaman.com.basebd.user.domain.User;

public interface UserRepository extends BaseMongoRepository<User> {

	List<User> findUserByMail(String mail);

	List<User> findUserName(String mail);

	boolean saveUser(User request);

	List<User> findLastUser();

	List<User> findUserById(ObjectId id);
}
