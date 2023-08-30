package pillihuaman.com.basebd.user.dao;

import org.bson.types.ObjectId;
import org.springframework.security.core.userdetails.UserDetailsService;
import pillihuaman.com.basebd.config.BaseMongoRepository;
import pillihuaman.com.basebd.user.User;


import java.util.List;
import java.util.Optional;

public interface UserRepository extends BaseMongoRepository<User> {

	List<User> findUserByMail(String mail);

	List<User> findUserName(String mail);

	boolean saveUser(User request);

	List<User> findLastUser();

	List<User> findUserById(ObjectId id);

	Optional<UserDetailsService> findByEmail(String mail);
}
