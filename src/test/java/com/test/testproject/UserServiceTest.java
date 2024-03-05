package com.test.testproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


// wkurwial mnie wykrzyknik a nie chce mi sie dodawac linijek kodu
@SuppressWarnings("OptionalGetWithoutIsPresent")
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

    @Test
    void getUserByNickNameAndPassword() {

        User user = new User();
        user.setNickName("Michas");
        user.setPasswordHash("Srichas");

        Optional<User> retrivedUser = userRepository.findByNickNameAndPasswordHash(user.getNickName(), user.getPasswordHash());
        assertNotNull(retrivedUser.get());
        assertEquals(user.getNickName(), retrivedUser.get().getNickName());
        assertEquals(user.getNickName(), retrivedUser.get().getNickName());
    }
}