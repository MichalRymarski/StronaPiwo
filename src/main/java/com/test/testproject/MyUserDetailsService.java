package com.test.testproject;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        UserDTO userDTO = userService.getUserByNickName(username);
        return org.springframework.security.core.userdetails.User
            .withUsername(userDTO.getNickName())
            .password(userDTO.getPasswordHash())
            .roles(userDTO.getRole())
            .build();
    }
}
