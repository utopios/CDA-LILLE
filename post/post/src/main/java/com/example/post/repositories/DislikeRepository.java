package com.example.post.repositories;

import com.example.post.entities.Dislike;
import com.example.post.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DislikeRepository extends JpaRepository<Dislike,Long> {
    List<Dislike> findByCommentId(Long commentID);
}
