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