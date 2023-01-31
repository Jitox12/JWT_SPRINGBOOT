package JWT.jwt.dto.auth;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AuthCredentials {

    private String email;
    private String password;
}
