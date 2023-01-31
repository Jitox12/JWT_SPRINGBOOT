package JWT.jwt.dao.userDao;

import JWT.jwt.dao.roleDao.RoleDao;
import JWT.jwt.dto.roleDto.GetRoleByIdDto;
import JWT.jwt.dto.userDto.CreateUserDto;
import JWT.jwt.dto.userDto.EditUserDto;
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
    public UserEntity findUserByIdDao(Integer userId) throws IOException {
        UserEntity user = userRepository.findByUserId(userId);
        return user;
    }

    @Override
    public List<UserEntity> findUserListDao() throws IOException{
        List<UserEntity> userList = userRepository.findAll();
        return userList;
    }


    @Override
    public void createUserDao(CreateUserDto createUserReq, GetRoleByIdDto roleDto) throws IOException{
        RoleEntity role = RoleEntity.builder().role(roleDto.getRoleDto()).roleId(roleDto.getRoleIdDto()).build();

        UserEntity user = UserEntity.builder()
                .userName(createUserReq.getUserNameDto())
                .userLastName(createUserReq.getUserLastNameDto())
                .email(createUserReq.getEmailDto())
                .password(createUserReq.getPasswordDto())
                .role(role)
                .build();

        userRepository.save(user);
    }

    @Override
    public void editUserDao(EditUserDto editUserReq, GetRoleByIdDto roleDto) throws IOException {
        RoleEntity role = RoleEntity.builder().role(roleDto.getRoleDto()).roleId(roleDto.getRoleIdDto()).build();

        UserEntity user = UserEntity.builder()
                .userId(editUserReq.getUserIdDto())
                .userName(editUserReq.getUserNameDto())
                .userLastName(editUserReq.getUserLastNameDto())
                .email(editUserReq.getEmailDto())
                .password(editUserReq.getPasswordDto())
                .role(role)
                .build();
        userRepository.save(user);
    }
}