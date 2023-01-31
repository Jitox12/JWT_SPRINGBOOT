package JWT.jwt.services.userServices;

import JWT.jwt.dto.userDto.CreateUserDto;
import JWT.jwt.dto.userDto.EditUserDto;
import JWT.jwt.dto.userDto.GetUserDto;
import JWT.jwt.entities.UserEntity;

import java.util.List;

public interface UserService {

    public GetUserDto findUserByIdService(Integer userId);
    public List<GetUserDto> findUserListService();


    public String createUserService(CreateUserDto createUserReq);

    public String editUserService(Integer userId, EditUserDto editUserReq);


}
