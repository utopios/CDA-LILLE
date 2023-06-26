package com.example.correctiontodolist.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ManyToAny;

@Entity
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String url;
    @ManyToOne
    private Todo todo;

}
