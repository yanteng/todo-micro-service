package com.example.training.userservice.controller;

import com.example.training.userservice.model.User;
import com.example.training.userservice.service.UserService;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("/login")
    public User login(@RequestBody User user, HttpServletResponse httpResponse){
        User loginUser = userService.login(user);
        if(loginUser != null )
            httpResponse.setHeader("token",userService.createToken(loginUser.getId()));
        return loginUser;
    }
    @PostMapping
    public User register(@RequestBody User user){
        return userService.registerUser(user);
    }
    @GetMapping("/verification")
    public User parseToken(){
        return userService.getPrinciple();
    }
}
