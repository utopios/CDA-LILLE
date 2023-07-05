package com.example.blogspringdto.service.impl;


import com.example.blogspringdto.dto.PostDto;
import com.example.blogspringdto.entity.Post;
import com.example.blogspringdto.exception.ResourceNotFoundException;
import com.example.blogspringdto.repository.CommentRepository;
import com.example.blogspringdto.repository.PostRepository;
import com.example.blogspringdto.service.PostService;
import com.example.blogspringdto.utils.Mapper;
import org.modelmapper.ModelMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class PostServiceImpl implements PostService {



    @Autowired
    private PostRepository postRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public PostDto createPost(PostDto postDto) {

        //convert dto to entity
        Post post = mapper.mapToEntity(postDto);

        Post newPost = postRepository.save(post);

        //convert entity to dto
        PostDto postResponse = mapper.mapToDto(newPost);

        return postResponse;
    }

   @Override
    public List<PostDto> getAllPosts() {

        List<Post>  posts = (List<Post>) postRepository.findAll();

        List<PostDto> postDtoList =  posts.stream().map(post->mapper.mapToDto(post)).collect(Collectors.toList());


        return postDtoList;
    }

    @Override
    public PostDto getPostById(long id) {
        //get post by id from the database
        Post post = getPostByIdFromDatabase(id);

        return mapper.mapToDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        //get post by id from the database
        Post post = getPostByIdFromDatabase(id);

        //update post
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        //return and save updated post in the database
        Post updatePost = postRepository.save(post);
        return mapper.mapToDto(updatePost);
    }

    @Override
    public void deletePostById(long id) {
        //get post by id from the database
        Post post = getPostByIdFromDatabase(id);

        //delete post from database
        postRepository.deleteById(id);


    }

    //get post by id from the database
    private Post getPostByIdFromDatabase(long id) {

        return postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
    }



}
