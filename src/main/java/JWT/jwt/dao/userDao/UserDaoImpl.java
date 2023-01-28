package JWT.jwt.dao.userDao;

import JWT.jwt.dao.roleDao.RoleDao;
import JWT.jwt.dto.userDto.UserRequestDto;
import JWT.jwt.entities.RoleEntity;
import JWT.jwt.entities.UserEntity;
import org.springframework.stereotype.Component;
import JWT.jwt.repositories.UserRepository;

import java.io.IOException;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    private final UserRepository userRepository;
    private final RoleDao roleDao;

    public UserDaoImpl(UserRepository userRepository, RoleDao roleDao) {
        this.userRepository = userRepository;
        this.roleDao = roleDao;
    }


    @Override
    public UserEntity findUserByIdDao(Integer userId) {
        try {
            UserEntity user = userRepository.findByUserId(userId);
            return user;
        } catch (Error e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<UserEntity> findUserListDao() {
        try {
            List<UserEntity> userList = userRepository.findAll();
            return userList;
        } catch (Error e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void createUserDao(UserRequestDto userReq)  {
        try {
            RoleEntity role = roleDao.findRoleByIdDao(userReq.getRoleIdDto());

            UserEntity user = UserEntity.builder()
                    .userName(userReq.getUserNameDto())
                    .userLastName(userReq.getUserLastNameDto())
                    .email(userReq.getEmailDto())
                    .password(userReq.getPasswordDto())
                    .role(role)
                    .build();
            userRepository.save(user);

        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editUserDao(UserRequestDto userReq) {
        RoleEntity role = null;
        try {
            role = roleDao.findRoleByIdDao(userReq.getRoleIdDto());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

            UserEntity user = UserEntity.builder()
                    .userId(userReq.getUserIdDto())
                    .userName(userReq.getUserNameDto())
                    .userLastName(userReq.getUserLastNameDto())
                    .email(userReq.getEmailDto())
                    .password(userReq.getPasswordDto())
                    .role(role)
                    .build();
        userRepository.save(user);
    }
}