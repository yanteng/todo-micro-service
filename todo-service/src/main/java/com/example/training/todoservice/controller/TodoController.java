package com.example.training.todoservice.controller;

import com.example.training.todoservice.model.Todo;
import com.example.training.todoservice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    TodoService todoService;
    @GetMapping
    public Page<Todo> getTodos(Pageable pageable){
        return todoService.getTodos(pageable);
    }
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable("id") Long id){
        return todoService.getTodoById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo);
    }
    @DeleteMapping("/{id}")
    public void deleteTodoById(@PathVariable("id") Long id){
        todoService.deleteTodoById(id);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Todo updateTodoById(@PathVariable("id") Long id,@RequestBody Todo todo){
        return todoService.updateTodoById(id,todo);
    }
}
