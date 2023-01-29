package JWT.jwt.dto.userDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {


    @NotNull(message = "User Name Is Null")
    @NotEmpty(message = "User Name Is Empty")
    @Size(min = 3, max = 15,message = "Min Size 5 & Max Size 15")
    private String userNameDto;

    @NotNull(message = "Password Is Null")
    @NotEmpty(message = "Password Is Empty")
    @Size(min = 5, max = 15, message = "Min Size 5 & Max Size 15")
    private String userLastNameDto;

    @NotNull(message = "Email Is Null")
    @NotEmpty(message = "Email Is Empty")
    @Email(message = "Invalid Email Format")
    private String emailDto;
}