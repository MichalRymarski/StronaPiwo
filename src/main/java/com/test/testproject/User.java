package com.test.testproject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity //Hibernate ctrl Q
@Data //Lombok automatycznie generuje settery i gettery z klas z ta adnotacja
@Table(name = "users")//tabela w liczbie mnogiej pisana zawsze + USER to slowo klucz w sqlu i mialem blad xD
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //SAMO GENERUJE ID NO WAY💀💀💀💀
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nick_name", unique = true) //pola w bazie z underscorem i małymi, pola w javie camelCasem
    private String nickName;

    @Column(name = "email")
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "role",nullable = false)
    private String role;

    @PrePersist
    private void setDefaultRole(){
        role = "USER";
    }
}