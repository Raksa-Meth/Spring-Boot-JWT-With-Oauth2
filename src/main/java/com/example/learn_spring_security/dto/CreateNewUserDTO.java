package com.example.learn_spring_security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateNewUserDTO {
    String username;
    String password;
}
