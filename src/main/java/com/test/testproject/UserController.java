package com.test.testproject;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//aby sie nie pierdolic -> mozesz pozniej zmienic


@CrossOrigin(origins = "http://localhost:63342") //taki jest localhost dla webu default
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper = UserMapper.INSTACE;


    @PostMapping(value = "/users")
    public UserDTO addSampleUser() {
        User user = new User();
        user.setNickName("buba");
        user.setPasswordHash("Michas");
        UserDTO newUser = userService.addUser(userMapper.toDTO(user));
        return newUser;
    }


    @GetMapping(value = "/users")
    public List<UserDTO> getSampleUser() {
        User user = new User();
        user.setNickName("buba");
        user.setPasswordHash("Michas");
        user.setIsAdmin(false);
        UserDTO newUser = userService.addUser(userMapper.toDTO(user));
        userService.addUser(newUser);
        return userService.getAllUsers();
    }

}