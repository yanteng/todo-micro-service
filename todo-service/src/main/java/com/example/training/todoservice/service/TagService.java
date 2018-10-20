package com.example.training.todoservice.service;

import com.example.training.todoservice.model.Tag;
import com.example.training.todoservice.model.Todo;
import com.example.training.todoservice.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public List<Tag> findByNameAndUserId(String name, Long userId){
        return tagRepository.findByNameAndUserId(name,userId);
    }

    public List<Tag> findByUserId(Long userId){
        return tagRepository.findByUserId(userId);
    }
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }
}
