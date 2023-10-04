package pillihuaman.com.basebd.user.dao;

import org.bson.types.ObjectId;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import pillihuaman.com.basebd.config.BaseMongoRepository;
import pillihuaman.com.basebd.user.User;
import pillihuaman.com.basebd.common.MyJsonWebToken;


import java.util.List;
import java.util.Optional;

public interface UserRepository extends BaseMongoRepository<User> {

    List<User> findUserByMail(String mail);

    List<User> findUserName(String mail);

    User saveUser(User request, MyJsonWebToken jwt);

    List<User> findLastUser();

    List<User> findUserById(ObjectId id);

    Optional<User> findByEmail(String mail);

    int getLastIdUser();

    List<User> listByStatus(boolean status);
}
