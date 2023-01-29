package JWT.jwt.dto.userDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class GetUserDto extends UserDto {

    @NotNull(message = "Role Name Is Null")
    @NotEmpty(message = "Role Name Is Empty")
    private String roleNameDto;
}