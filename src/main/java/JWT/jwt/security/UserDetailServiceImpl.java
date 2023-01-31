package JWT.jwt.security;

import JWT.jwt.dto.auth.AuthDto;
import JWT.jwt.dto.userDto.GetUserDto;
import JWT.jwt.services.authServices.AuthService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDetailServiceImpl implements UserDetailsService {


    private final AuthService authService;

    public UserDetailServiceImpl(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AuthDto user = authService.findUserByEmail(email);
        return new UserDetailsImpl(user);
    }


}
