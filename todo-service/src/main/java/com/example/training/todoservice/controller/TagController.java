package com.example.training.todoservice.controller;

import com.example.training.todoservice.model.Tag;
import com.example.training.todoservice.service.TagService;
import com.example.training.todoservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todos/tags")
public class TagController {
    @Autowired
    TagService tagService;
    @Autowired
    UserService userService;
    @GetMapping("/users")
    public List<Tag> getTagsByUserId(){
        return tagService.findByUserId(
                userService.getContextUser().getId()
        );
    }
}
