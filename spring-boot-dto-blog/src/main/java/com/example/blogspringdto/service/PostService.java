package com.example.blogspringdto.service;


import com.example.blogspringdto.dto.PostDto;

import java.util.List;


public interface PostService {

    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts();

    PostDto getPostById( long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);

}
