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
    private final PasswordEncoderConfig passwordEncoder;
    @PostMapping
    public UserDTO registerUser(@RequestBody RegistrationDTO request){
        User user = new User();
        user.setNickName(request.getNickName());
        String hashedPassword = passwordEncoder.passwordEncoder().encode(request.getUnhashedPassword());
        user.setPasswordHash(hashedPassword);

        return userService.registerUser(user);
    }
}
