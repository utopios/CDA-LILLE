package com.example.post.service.interfaces;


import com.example.post.dtos.DislikeCreateCommentDTO;
import com.example.post.dtos.DislikeViewDTO;

import java.util.List;
import java.util.Optional;

public interface DislikeService {

    void delete(Long id);

    List<DislikeViewDTO> getAllLikesByCommentId( Optional<Long> commentID);

    DislikeViewDTO createDislikeComment(DislikeCreateCommentDTO dislikeCreateCommentDTO);
}
