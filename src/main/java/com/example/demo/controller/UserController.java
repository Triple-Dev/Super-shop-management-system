package com.example.demo.controller;

import com.example.demo.Model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("admin")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("setUser")
    @ResponseBody
    public User setUser(@RequestBody User user){
        return userService.setUser(user);
    }

    @GetMapping("createUser")
    @ResponseBody
    public User setUser(){
        User user=new User("ninad","babu","customer",true,false);
        return userService.setUser(user);
    }

    @GetMapping("users")
    @ResponseBody
    public Iterable<User> getUsers(){
        return userService.getUsers();
    }

}
