package com.example.post.controllers;


import com.example.post.dtos.DislikeCreateCommentDTO;
import com.example.post.dtos.DislikeViewDTO;
import com.example.post.service.interfaces.DislikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DislikeController {

    @Autowired
    private  DislikeService dislikeService;

    @PostMapping("/dislikes/comment")
    @ResponseStatus(HttpStatus.CREATED)
    public DislikeViewDTO dislikeCreateComment(@RequestBody DislikeCreateCommentDTO dislikeCreateCommentDTO){
        return dislikeService.createDislikeComment(dislikeCreateCommentDTO);
    }

    @DeleteMapping("/dislikes/{id}")
    public void deleteDislike(@PathVariable Long id){
        dislikeService.delete(id);
    }

    @GetMapping("/dislikes")
    public List<DislikeViewDTO> getAllWithParams( @RequestParam Optional<Long> commentId) {
        return dislikeService.getAllLikesByCommentId(commentId);
    }

}

