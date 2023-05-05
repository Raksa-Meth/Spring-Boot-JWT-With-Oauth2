package com.example.learn_spring_security.Service;

import com.example.learn_spring_security.dto.CreateNewUserDTO;
import com.example.learn_spring_security.model.Role;
import com.example.learn_spring_security.model.User;
import com.example.learn_spring_security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    public ResponseEntity<?> addNewUser(CreateNewUserDTO newUserData) {
        var newUser = new User(newUserData.getUsername(),new BCryptPasswordEncoder().encode(newUserData.getPassword()), Role.USER, true);
        userRepo.save(newUser);
        return ResponseEntity.ok("User created");
    }
}
