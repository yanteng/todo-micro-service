package com.example.training.todoservice.service;

import com.example.training.todoservice.model.Tag;
import com.example.training.todoservice.model.Todo;
import com.example.training.todoservice.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    UserService userService;
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private TagService tagService;

    public Page<Todo> getTodos(Pageable pageable) {
        return todoRepository.findAllByUserId(pageable, userService.getContextUser().getId());
    }

    public Todo addTodo(Todo todo) {
        todo.getTags().forEach(tag -> {
            List<Tag> savedTags = tagService.findByNameAndUserId(tag.getName(), tag.getUserId());
            if (savedTags != null && !savedTags.isEmpty()) {
                tag.setId(savedTags.get(0).getId());
            } else {
                tagService.save(tag);
            }
        });
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
