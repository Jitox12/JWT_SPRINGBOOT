package JWT.jwt.services.authServices;

import JWT.jwt.dao.authDao.AuthDao;
import JWT.jwt.dto.auth.AuthDto;
import JWT.jwt.entities.UserEntity;
import JWT.jwt.mappers.authMappers.GetAuthMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthDao authDao;
    private final GetAuthMapper getUserJwtMapper;

    public AuthServiceImpl(AuthDao authDao, GetAuthMapper getUserJwtMapper) {
        this.authDao = authDao;
        this.getUserJwtMapper = getUserJwtMapper;
    }
    @Override
    public AuthDto findUserByEmail(String email) {

        try {
            UserEntity user = authDao.findUserByEmail(email);

            AuthDto userDto = getUserJwtMapper.userEntityToUserJwtDto(user);
            return userDto;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
