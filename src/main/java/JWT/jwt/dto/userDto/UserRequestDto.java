package JWT.jwt.dto.userDto;

import JWT.jwt.entities.RoleEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDto extends UserDto{
    private Integer userIdDto;
    private Integer roleIdDto;
    private String passwordDto;
}