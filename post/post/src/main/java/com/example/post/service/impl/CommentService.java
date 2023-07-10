package com.example.post.service.impl;


import com.example.post.dtos.CommentCreateDTO;
import com.example.post.dtos.CommentUpdateDTO;
import com.example.post.dtos.CommentViewDTO;
import com.example.post.entities.Comment;
import com.example.post.entities.Post;
import com.example.post.exceptions.GlobalException;
import com.example.post.repositories.CommentRepository;
import com.example.post.repositories.PostRepository;
import com.example.post.utils.DtoUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService implements com.example.post.service.interfaces.CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private DtoUtils dtoUtils;

    @Override
    public CommentViewDTO getCommentById(Long id) throws GlobalException {
        final Comment comment = this.commentRepository.findById(id).orElseThrow(() -> new GlobalException("Non trouvé"));
        return dtoUtils.convertToDto(comment, new CommentViewDTO(), CommentViewDTO.class);
    }

    @Override
    public CommentViewDTO createComment(CommentCreateDTO commentCreateDTO) {
        Post post = postRepository.findById(commentCreateDTO.getPostId()).get();
        Comment comment = commentRepository.save(new Comment(commentCreateDTO.getText(), post));
        if (comment == null) {
            throw new GlobalException("Pas de commentaire trouvé") ;
        }
        return dtoUtils.convertToDto(comment, new CommentViewDTO(), CommentViewDTO.class);
    }

    @Override
    public CommentViewDTO updateComment(Long id, CommentUpdateDTO commentUpdateDTO) throws GlobalException {
        Comment comment = this.commentRepository.findById(id).orElseThrow(() -> new GlobalException("Non trouvé"));
        comment.setId(comment.getId());
        comment.setText(commentUpdateDTO.getText());
        commentRepository.save(comment);
        return dtoUtils.convertToDto(comment, new CommentViewDTO(), CommentViewDTO.class);
    }

    @Override
    public void deleteComment(Long id) throws GlobalException {
        Comment comment = this.commentRepository.findById(id).orElseThrow(() -> new GlobalException("Impossible de supprimer"));
        this.commentRepository.deleteById(comment.getId());
    }

    @Override
    public List<CommentViewDTO> getAllCommentByPostId(Optional<Long> postId) {
        List<Comment> list;
        List<CommentViewDTO> commentViewDTOList = new ArrayList<>();

        commentRepository.findByPostId(postId.get()).stream().forEach((c) -> {
            commentViewDTOList.add(dtoUtils.convertToDto(c, new CommentViewDTO(), CommentViewDTO.class));

        });
        return commentViewDTOList;
    }
}
