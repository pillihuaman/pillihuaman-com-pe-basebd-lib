package pillihuaman.com.segurity.basebd.token.dao;

import pillihuaman.com.segurity.basebd.config.BaseMongoRepository;
import pillihuaman.com.segurity.basebd.token.Token;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends BaseMongoRepository<Token> {

    List<Token> findAllValidTokenByUser(Object id);

    Optional<Token> findByToken(String token);
}
