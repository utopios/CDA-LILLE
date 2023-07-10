package com.example.post.service.interfaces;



import com.example.post.dtos.CommentCreateDTO;
import com.example.post.dtos.CommentUpdateDTO;
import com.example.post.dtos.CommentViewDTO;
import com.example.post.exceptions.GlobalException;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    CommentViewDTO getCommentById(Long id) throws GlobalException;
    CommentViewDTO createComment(CommentCreateDTO commentCreateDTO);
    CommentViewDTO updateComment(Long id, CommentUpdateDTO commentUpdateDTO) throws Exception;
    void deleteComment(Long id) throws GlobalException;
    List<CommentViewDTO> getAllCommentByPostId(Optional<Long> postId);
}
