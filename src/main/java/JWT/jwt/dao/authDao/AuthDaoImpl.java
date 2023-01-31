package JWT.jwt.dao.authDao;

import JWT.jwt.entities.UserEntity;
import JWT.jwt.repositories.AuthRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthDaoImpl implements AuthDao {

    private final AuthRepository authRepository;

    public AuthDaoImpl(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public UserEntity findUserByEmail(String email) throws IOException {
        UserEntity user = authRepository.findByEmail(email);
        return user;
    }
}
