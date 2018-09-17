package com.example.demo.service;

import com.example.demo.Model.User;
import com.example.demo.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Iterable<User> getUsers(){
        return userRepo.findAll();
    }

    public User setUser(User user) {
        return userRepo.save(user);
    }
}
