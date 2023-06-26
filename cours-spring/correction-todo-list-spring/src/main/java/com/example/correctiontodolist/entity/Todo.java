package com.example.correctiontodolist.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "todo")
@Data
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String description;

    private Date date;

    private boolean status;
    
    @OneToMany(mappedBy = "todo", fetch = FetchType.EAGER)
    private List<Image> images;

    public Todo() {
        //images = new ArrayList<>();
    }
    public Todo(String title, String description) {
        this();
        this.setTitle(title);
        this.setDescription(description);
        this.setStatus(false);
        this.setDate(new Date());
    }
}
