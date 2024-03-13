package com.test.testproject;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("register")
public class RegistrationController {
    private final UserService userService;
    @PostMapping
    public UserDTO registerUser(@RequestBody String nickName, @RequestBody String unhashedPassword){
        return null; //TODO
    }
}
