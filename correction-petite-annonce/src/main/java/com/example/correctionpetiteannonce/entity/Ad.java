package com.example.correctionpetiteannonce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ad")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String description;

    private double price;

    @OneToMany(mappedBy = "ad", fetch = FetchType.EAGER)
    private List<Image> images;

    @ManyToMany
    private List<Category> categories;

    @ManyToOne
    private AppUser user;
}
