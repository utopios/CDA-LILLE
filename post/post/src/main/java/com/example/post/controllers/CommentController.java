package com.example.post.controllers;


import com.example.post.dtos.CommentCreateDTO;
import com.example.post.dtos.CommentUpdateDTO;
import com.example.post.dtos.CommentViewDTO;
import com.example.post.service.interfaces.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public ResponseEntity<List<CommentViewDTO>> getAll(@RequestParam Optional<Long> postId){

        if(postId != null && !commentService.getAllCommentByPostId(postId).isEmpty()){

            return new ResponseEntity<>(commentService.getAllCommentByPostId(postId), HttpStatus.FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<CommentViewDTO> getByCommentId(@PathVariable Long id){
        if(id != null && this.commentService.getCommentById(id) != null){

            return new ResponseEntity<>(this.commentService.getCommentById(id), HttpStatus.FOUND);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentViewDTO createComment(@Valid @RequestBody CommentCreateDTO commentCreateDTO){
        return this.commentService.createComment(commentCreateDTO);
    }

    @PutMapping("/comments/{id}")
    public CommentViewDTO updateComment(@PathVariable Long id, @RequestBody CommentUpdateDTO commentUpdateDTO){
        try {
            return commentService.updateComment(id,commentUpdateDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/comments/{id}")
    public void deleteComment(@PathVariable Long id){
        commentService.deleteComment(id);
    }
}