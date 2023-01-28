package JWT.jwt.services.userServices;

import JWT.jwt.dto.userDto.UserRequestDto;
import JWT.jwt.dto.userDto.UserResponseDto;
import JWT.jwt.entities.UserEntity;

import java.util.List;

public interface UserService {

    public UserResponseDto findUserByIdService(Integer userId);
    public List<UserResponseDto> findUserListService();

    public void createUserService(UserRequestDto userReq);

    public void editUserService(Integer userId, UserRequestDto userReq);
}
