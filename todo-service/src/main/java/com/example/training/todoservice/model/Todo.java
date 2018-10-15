package com.example.training.todoservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Todo {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String status;
    private Date dueDate;
    private Long userId;
    @ManyToMany
    @Cascade(value = CascadeType.SAVE_UPDATE)
    @JoinTable(name = "todo_tag",
            joinColumns = @JoinColumn(name = "todo_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags;
}
