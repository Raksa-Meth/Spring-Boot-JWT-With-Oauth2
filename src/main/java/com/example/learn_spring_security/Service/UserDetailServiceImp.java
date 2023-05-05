package com.example.learn_spring_security.Service;

import com.example.learn_spring_security.model.User;
import com.example.learn_spring_security.repo.UserRepo;
import com.example.learn_spring_security.ulti.UserDetailImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailServiceImp implements UserDetailsService {
    private UserRepo userRepo;

    public UserDetailServiceImp(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        System.out.println(user);
        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new UserDetailImp(user) {
        };
    }
}
