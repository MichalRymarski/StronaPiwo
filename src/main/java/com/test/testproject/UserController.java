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
    public List<UserDTO> getAllUsers() {
        User user = new User();
        user.setNickName("Michas");
        user.setPasswordHash("Srichas");
        user.setIsAdmin(false);
        UserDTO newUser = userService.addUser(userMapper.toDTO(user));
        userService.addUser(newUser);
        return userService.getAllUsers();
    }

    @GetMapping(value = "/clear")
    public void deleteUsers(){
        userService.clearDatabase();
    }

    @GetMapping(value = "/users/{nickName}")  //ZNAJDUJE DOBRZE ALE MUSISZ MIEC JEDNEGO CHLOPKA Z TAKIM IMIENIEM
    public UserDTO getSampleUser(@PathVariable String nickName,@RequestBody String password) { // W USER JEST UNIQUE NAME WIEC TO POZNIEJ NIE BEDZIE PROBLEMEM
        UserDTO user = userService.getUserByNickNameAndPassword(nickName,password);
        return user;
    }



}