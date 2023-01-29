package JWT.jwt.controllers;

import JWT.jwt.dto.userDto.CreateUserDto;
import JWT.jwt.dto.userDto.EditUserDto;
import JWT.jwt.dto.userDto.GetUserDto;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import JWT.jwt.services.userServices.UserService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/api/find-users")
    public List<GetUserDto> findAllUsers() throws IOException {
        List<GetUserDto> userRes = userService.findUserListService();
        return userRes;
    }

    @GetMapping(value = "/api/find-user/{userId}")
    public GetUserDto findAllUsers(@PathVariable(required = true)  Integer userId) throws IOException {
        GetUserDto userReq = userService.findUserByIdService(userId);
        return userReq;
    }

    @Transactional
    @PostMapping(value = "/api/create-user")
    public String createUser(@RequestBody @Valid CreateUserDto createUserReq) throws IOException {
        String user = userService.createUserService(createUserReq);
        return "Se ha creado el usuario ".concat(user);

    }

    @Transactional
    @PutMapping(value = "/api/edit-user/{userId}")
    public String editUser(@PathVariable(required = true) Integer userId, @RequestBody @Valid EditUserDto editUserReq) throws IOException{
        userService.editUserService(userId, editUserReq);
        return "Se ha editado el rol con Id ".concat(String.valueOf(userId));
    }
}