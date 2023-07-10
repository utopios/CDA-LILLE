package com.example.post.service.interfaces;


import com.example.post.dtos.PostCreateDTO;
import com.example.post.dtos.PostUpdateDTO;
import com.example.post.dtos.PostViewDTO;

import java.util.List;

public interface PostService {
    PostViewDTO createPost(PostCreateDTO postCreateDTO);
    PostViewDTO updatePost(Long id, PostUpdateDTO postUpdateDTO);
    void deletePost(Long id);
    List<PostViewDTO> getALlPostByUserId(Long userId);
    PostViewDTO getPostById(Long id);

}
