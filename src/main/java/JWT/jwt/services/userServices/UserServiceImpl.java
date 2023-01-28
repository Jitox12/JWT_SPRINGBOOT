package JWT.jwt.services.userServices;

import JWT.jwt.dao.userDao.UserDao;
import JWT.jwt.dto.userDto.UserRequestDto;
import JWT.jwt.dto.userDto.UserResponseDto;
import JWT.jwt.entities.UserEntity;
import JWT.jwt.mappers.userMappers.UserReqMapper;
import JWT.jwt.mappers.userMappers.UserResMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final UserReqMapper userReqMapper;
    private final UserResMapper userResMapper;

    public UserServiceImpl(UserDao userDao, UserReqMapper userReqMapper, UserResMapper userResMapper) {
        this.userDao = userDao;
        this.userReqMapper = userReqMapper;
        this.userResMapper = userResMapper;
    }


    @Override
    public UserResponseDto findUserByIdService(Integer userId) {
        try {
            UserEntity user = userDao.findUserByIdDao(userId);
            UserResponseDto userDto = userResMapper.userEntityToUserResDto(user);

            return userDto;
        } catch (Error e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<UserResponseDto> findUserListService() {
        try {
            List<UserEntity> user = userDao.findUserListDao();
            List<UserResponseDto> userRes = user.stream().map(userResMapper::userEntityToUserResDto).collect(Collectors.toList());
            return userRes;
        } catch (Error e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void createUserService(UserRequestDto userReq) {
        try{
            userDao.createUserDao(userReq);
        }catch (Error e){
            throw new RuntimeException();
        }
    }

    @Override
    public void editUserService(Integer userId, UserRequestDto userReq) {
    try{
        userReq.setUserIdDto(userId);
        userDao.editUserDao(userReq);

    }catch (Error e){
        throw new RuntimeException();
    }
    }
}
