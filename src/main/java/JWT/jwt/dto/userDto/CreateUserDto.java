package JWT.jwt.dto.userDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserDto extends UserDto {

    private Integer roleIdDto;

    @NotNull(message = "Password Is Null")
    @NotEmpty(message = "Password Is Empty")
    @Size(min = 5, message = "Min Size 5")
    private String passwordDto;
}