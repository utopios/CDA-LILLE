package com.example.post.repositories;


import com.example.post.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like,Long> {


    List<Like> findByCommentId(Long postId);



}
