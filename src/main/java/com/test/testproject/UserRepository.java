package com.test.testproject;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {
    //to sie nazywa derived query methods , na baeldungu se poczytaj https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
    //optionale sa bezpieczne i dalej przy kodzie pomoga nie nullchechkowac bez przerwy
    Optional<User> findByNickNameAndPasswordHash(String nickName, String passwordHash);//to samo generuje zapytanie po nazwie metody 😘😘😘
    Optional<User> findByNickNameAndPasswordHashAndIsAdminIsTrue(String nickName, String passwordHash);
    Optional<User> findByNickName(String nickName);

}
