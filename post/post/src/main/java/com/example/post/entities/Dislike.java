package com.example.post.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import org.modelmapper.internal.bytebuddy.asm.Advice;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name="dislike")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dislike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @Column(name = "date")
    Date date;
    public Dislike(Comment comment, Date date) {
        this.date = date;
        this.comment = comment;
    }
}
