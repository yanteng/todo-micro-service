package com.example.training.todoservice.service;

import com.example.training.todoservice.Specification.SpecificationBuilder;
import com.example.training.todoservice.model.Tag;
import com.example.training.todoservice.model.Todo;
import com.example.training.todoservice.repository.TodoRepository;
import com.example.training.todoservice.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    UserService userService;
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private TagService tagService;

    public Page<Todo> getTodos(Pageable pageable, String name, Date from, Date to, String status) {
        SpecificationBuilder specificationBuilder = new SpecificationBuilder();
        if(!StringUtils.isEmpty(name))
            specificationBuilder.with("name",":",name);
        if(!DateUtils.equals(from,to)){
            if(from != null)
                specificationBuilder.with("dueDate",">",from);
            if(to != null)
                specificationBuilder.with("dueDate","<",to);
        }
        if(!StringUtils.isEmpty(status))
            specificationBuilder.with("status",":",status);
        specificationBuilder.with("userId",":", userService.getContextUser().getId());
        return todoRepository.findAll(specificationBuilder.build(),pageable);
    }

    public Todo addTodo(Todo todo) {
        Long userId = userService.getContextUser().getId();
        todo.setUserId(userId);
        todo.getTags().forEach(tag -> {
            tag.setUserId(userId);
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
