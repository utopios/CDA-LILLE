package com.example.post.controllers;

import com.example.post.dtos.LikeCreateCommentDTO;
import com.example.post.dtos.LikeViewDTO;
import com.example.post.service.interfaces.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LikeController {

    @Autowired
    private LikeService likeService;


    @DeleteMapping("/likes/{id}")
    public void deleteLike(@PathVariable Long id){
        likeService.delete(id);
    }

    @GetMapping("/likes")
    public List<LikeViewDTO> getAllLikes(@RequestParam Optional<Long> commentId) {
        return likeService.getAllLikesByCommentId(commentId);
    }

    @PostMapping("/likes/comment")
    @ResponseStatus(HttpStatus.CREATED)
    public LikeViewDTO addLikeComment(@RequestBody LikeCreateCommentDTO likeCreateCommentDTO) throws ParseException {
        return likeService.createLikeComment(likeCreateCommentDTO);
    }

}
