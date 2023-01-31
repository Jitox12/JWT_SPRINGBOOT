package JWT.jwt.dao.authDao;

import JWT.jwt.entities.UserEntity;

import java.io.IOException;

public interface AuthDao {
    public UserEntity findUserByEmail(String emailDto) throws IOException;

}
