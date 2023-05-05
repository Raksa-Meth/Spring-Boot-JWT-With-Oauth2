package com.example.learn_spring_security.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user_detail")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String username;
    String password;
    String role;
    boolean active;

    public User(String username, String password, String role, boolean active){
        this.username = username;
        this.password = password;
        this.role = role;
        this.active = active;
    }

}
