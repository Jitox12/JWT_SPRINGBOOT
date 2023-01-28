package JWT.jwt.dao.userDao;

import JWT.jwt.dto.userDto.UserRequestDto;
import JWT.jwt.entities.UserEntity;

import java.util.List;

public interface UserDao {

    public UserEntity findUserByIdDao(Integer userId);
    public List<UserEntity> findUserListDao();

    public void createUserDao(UserRequestDto userReq);

    public void editUserDao(UserRequestDto userReq);

}
