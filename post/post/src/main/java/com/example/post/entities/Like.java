package com.example.post.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name="likes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Column(name = "date")
    Date date;
    public Like(Comment comment, Date date){
        this.date = date;
       this.comment = comment;

    }



}
