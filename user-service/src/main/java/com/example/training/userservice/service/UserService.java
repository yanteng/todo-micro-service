package com.example.training.userservice.service;

import com.example.training.userservice.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private byte[] key = "hello".getBytes();
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public String createToken(Long id){
        return Jwts.builder().claim("id",id).signWith(SignatureAlgorithm.HS256,key).compact();
    }
    public User parseToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return userRepository.findOne(claims.get("id", Long.class));
    }

    public User getPrinciple() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public User login(User user) {
        User savedUser = userRepository.findOne(user.getId());
        if (savedUser != null && savedUser.getPassword().equals(user.getPassword())) {
            return savedUser;
        }
        return null;
    }
}
