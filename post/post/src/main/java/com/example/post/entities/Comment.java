package com.example.post.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Table(name="comment")
@Data
@NoArgsConstructor
public class Comment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToMany(mappedBy = "comment",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Like> likes;

    @OneToMany(mappedBy = "comment",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Dislike> disLikes;

    public Comment(String text,Post post) {
        this.text = text;
        this.post=post;
    }


}