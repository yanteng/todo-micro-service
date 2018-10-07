package com.example.training.todoservice.service;

import com.example.training.todoservice.model.Todo;
import com.example.training.todoservice.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo getTodoById(Long id) {
        return todoRepository.findOne(id);
    }

    public void deleteTodoById(Long id) {
        todoRepository.delete(id);
    }

    public Todo updateTodoById(Long id, Todo todo) {
        todo.setId(id);
        return todoRepository.save(todo);
    }
}
