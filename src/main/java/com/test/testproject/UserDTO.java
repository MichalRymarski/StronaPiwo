package com.test.testproject;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Value //wszystkie pola sa final z Lomboka

public class UserDTO implements Serializable { // to wszystko lombok zrobil GG op jak skurwysyn  SERIALIZABLE - CTRL Q
    Long id;
    String nickName;
    String email;
    String passwordHash;
    Boolean isAdmin;
}