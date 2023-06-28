package com.example.correctionpetiteannonce.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private double price;

    @OneToMany(mappedBy = "ad", fetch = FetchType.EAGER)
    private List<Image> images;

    @ManyToMany
    private List<Category> categories;

    @ManyToOne
    private AppUser user;
}
