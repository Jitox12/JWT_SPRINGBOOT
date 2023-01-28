package JWT.jwt.controllers;

import JWT.jwt.dto.userDto.UserRequestDto;
import JWT.jwt.dto.userDto.UserResponseDto;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import JWT.jwt.services.userServices.UserService;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value ="/api/users")
    public List<UserResponseDto> findAllUsers(){
        List<UserResponseDto> userRes = userService.findUserListService();

        return userRes;
    }

    @GetMapping(value = "/api/user/{userId}")
    public UserResponseDto findAllUsers(@PathVariable Integer userId){
       try{
           UserResponseDto userReq = userService.findUserByIdService(userId);
           return userReq;
       }catch (Error e){
           throw new RuntimeException();
       }
    }

    @Transactional
    @PostMapping(value = "/api/create-user")
    public void createUser(@RequestBody UserRequestDto userReq){
        try{
            userService.createUserService(userReq);
        }catch (Error e){
            throw new RuntimeException();
        }
    }

    @Transactional
    @PutMapping(value = "/api/edit-user/{userId}")
    public void editUser(@PathVariable Integer userId, @RequestBody UserRequestDto userReq){
        try{
            userService.editUserService(userId, userReq);
        }catch (Error e){
            throw new RuntimeException();
        }
    }
}