package com.example.training.todoservice.service;

import com.example.training.todoservice.feign.UserFeignClient;
import com.example.training.todoservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserFeignClient userFeignClient;

    public User parseToken(String token){
        return userFeignClient.verificationUser(token);
    }

    public User getContextUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
