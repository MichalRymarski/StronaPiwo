package com.test.testproject;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//aby sie nie pierdolic -> mozesz pozniej zmienic


@CrossOrigin(origins = "http://localhost:63342") //taki jest localhost dla webu default
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper = UserMapper.INSTACE;


    @GetMapping(value = "/sample")
    public UserDTO addSampleUser(){
        User user = new User();
        user.setNickName("Nichas");
        user.setPasswordHash("$2a$12$wsmF25q8MOGDLOYA3/WO4e620FM.n/09/ROS0vhISVQbzzya1fOgK");
        user.setRole("ADMIN");
        userService.addUser(userMapper.toDTO(user));
        return userMapper.toDTO(user);
    }
    @GetMapping(value = "/all")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/clear")
    public void deleteUsers(){
        userService.clearDatabase();
    }

    @GetMapping(value = "/{nickName}")  //ZNAJDUJE DOBRZE ALE MUSISZ MIEC JEDNEGO CHLOPKA Z TAKIM IMIENIEM
    public UserDTO getSampleUser(@PathVariable String nickName,@RequestBody String password) { // W USER JEST UNIQUE NAME WIEC TO POZNIEJ NIE BEDZIE PROBLEMEM
        UserDTO user = userService.getUserByNickNameAndPassword(nickName,password);
        return user;
    }



}