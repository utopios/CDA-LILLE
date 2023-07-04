package com.example.demorest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "todo_list")
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "complete")
    private Boolean complete;

    @OneToMany(mappedBy = "todoList")
    private Set<TodoItem> todoItems = new LinkedHashSet<>();

}