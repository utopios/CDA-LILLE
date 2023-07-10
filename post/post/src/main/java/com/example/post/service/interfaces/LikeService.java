package com.example.post.service.interfaces;


import com.example.post.dtos.LikeCreateCommentDTO;
import com.example.post.dtos.LikeViewDTO;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface LikeService {


    void delete(Long id);

    List<LikeViewDTO> getAllLikesByCommentId(Optional<Long> postId);

    LikeViewDTO createLikeComment(LikeCreateCommentDTO likeCreateCommentDTO) throws ParseException;

}
