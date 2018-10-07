package com.example.training.todoservice.repository;

import com.example.training.todoservice.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long>{

}
