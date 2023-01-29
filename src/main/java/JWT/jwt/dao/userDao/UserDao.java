package JWT.jwt.dao.userDao;

import JWT.jwt.dto.roleDto.GetRoleByIdDto;
import JWT.jwt.dto.userDto.CreateUserDto;
import JWT.jwt.dto.userDto.EditUserDto;
import JWT.jwt.entities.UserEntity;

import java.io.IOException;
import java.util.List;

public interface UserDao {

    public UserEntity findUserByIdDao(Integer userId) throws IOException;
    public List<UserEntity> findUserListDao() throws IOException;

    public void createUserDao(CreateUserDto createUserReq, GetRoleByIdDto roleDto) throws IOException;

    public void editUserDao(EditUserDto editUserReq, GetRoleByIdDto roleDto) throws IOException;

}
