package JWT.jwt.dto.auth;


import JWT.jwt.dto.userDto.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class AuthDto extends UserDto {

    @NotNull(message = "Password Is Null")
    @NotEmpty(message = "Password Is Empty")
    @Size(min = 5, message = "Min Size 5")
    private String passwordDto;

    @NotNull(message = "roleName Is Null")
    @NotEmpty(message = "roleName Is Empty")
    private String roleNameDto;
}
