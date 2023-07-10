package com.example.post.dtos;

import com.example.post.entities.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class PostViewDTO
{
    private Long id;
    private  String title;
    private  String text;
    private List<CommentViewDTO> comments;



}
