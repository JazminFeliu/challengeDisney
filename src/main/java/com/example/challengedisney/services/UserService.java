package com.example.challengedisney.services;

import com.example.challengedisney.entities.User;
import com.example.challengedisney.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public String save(User user){
        if(userRepository.existsByNameOrEmail(user.getName(), user.getEmail()))
            return "Usuario existente";

        int num = (int) (Math.random()*100)+1;
        user.setToken(user.getName()+num);
        user.setApi_call_limit(1000);
        user.setApi_calls_available(1000);
        userRepository.save(user);
        return user.getToken();
    }

    public String login(String email, String token){
        User user = userRepository.findUserByEmailAndToken(email, token);
        if(user != null){
            user.setTokenTemporal(String.valueOf((Math.round(Math.random()*100000)+1)));
            userRepository.save(user);
            return user.getTokenTemporal();
        }
        return "Error de acceso";
    }

}
