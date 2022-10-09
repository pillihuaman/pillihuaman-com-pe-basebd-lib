package pillihuaman.com.user.domain.dao;

import java.util.List;

import pillihuaman.com.config.BaseMongoRepository;
import pillihuaman.com.user.domain.User;

public interface UserRepository extends BaseMongoRepository<User> {

	List<User> findUserByMail(String mail);

	List<User> findUserName(String mail);

	boolean saveUser(User request);

	List<User> findLastUser();
}
