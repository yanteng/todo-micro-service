package com.example.training.todoservice.feign;

import com.example.training.todoservice.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

//@FeignClient(name = "user-service",url = "http://localhost:8083")
@FeignClient(name = "user-service",url = "http://user-service:8083")
public interface UserFeignClient {
    @GetMapping("/users/verification")
    public User verificationUser(@RequestHeader("token") String token);
}
