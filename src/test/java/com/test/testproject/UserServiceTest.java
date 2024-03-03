package com.test.testproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ActiveProfiles("test")
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveUser_NewUser_UserIsSaved() {
        // Create a new user
        User user = new User();
        user.setNickName("Michas");
        user.setPasswordHash("bubu");

        // Save the user
        User savedUser = userRepository.save(user);

        // Retrieve the user
        User retrievedUser = userRepository.findById(savedUser.getId()).orElse(null);

        // Check that the user was saved correctly
        assertNotNull(retrievedUser);
        assertEquals(user.getNickName(), retrievedUser.getNickName());
        assertEquals(user.getPasswordHash(), retrievedUser.getPasswordHash());
    }
}