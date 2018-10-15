package com.example.training.todoservice.repository;

import com.example.training.todoservice.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
    public List<Tag> findByNameAndUserId(String name, Long id);
}
