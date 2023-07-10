package com.example.post.dtos;


import com.example.post.entities.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentViewDTO {
    private Long id;
    private String text;
    private List<LikeViewDTO> likes;
    private List<DislikeViewDTO> disLikes;


}
