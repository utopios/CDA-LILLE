package com.example.post.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Data
@Table(name = "post")
@NoArgsConstructor
@AllArgsConstructor
public class Post{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @OneToMany(mappedBy = "post",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Post(String title, String text, User user) {
        this.title = title;
        this.text = text;
        this.user = user;
    }
}