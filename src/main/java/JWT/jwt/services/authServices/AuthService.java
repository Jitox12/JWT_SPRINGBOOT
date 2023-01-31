package JWT.jwt.services.authServices;

import JWT.jwt.dto.auth.AuthDto;

public interface AuthService {

    public AuthDto findUserByEmail(String email);

}
