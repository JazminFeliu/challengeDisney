package com.example.challengedisney.controllers;

import com.example.challengedisney.entities.User;
import com.example.challengedisney.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController (UserService userService){
        this.userService = userService;
    }

    @PostMapping(path = "/auth/register", consumes = "application/json")
    public String register(@RequestBody User usuario){
        return userService.save(usuario);
    }

    @PostMapping(path = "/auth/login")
    public String login(@RequestParam String email, @RequestParam String token){
        return userService.login(email, token);
    }

}
