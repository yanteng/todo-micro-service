package com.example.training.todoservice.repository;

import com.example.training.todoservice.model.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long>{
    public Page<Todo> findAllByUserId(Pageable pageable, Long userId);
}
