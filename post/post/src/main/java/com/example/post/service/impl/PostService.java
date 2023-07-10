package com.example.post.service.impl;


import com.example.post.dtos.PostCreateDTO;
import com.example.post.dtos.PostUpdateDTO;
import com.example.post.dtos.PostViewDTO;
import com.example.post.entities.Post;
import com.example.post.entities.User;
import com.example.post.repositories.PostRepository;
import com.example.post.repositories.UserRepository;
import com.example.post.utils.DtoUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PostService implements com.example.post.service.interfaces.PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;





    @Autowired
    DtoUtils dtoUtils;

    @Override
    public PostViewDTO createPost(PostCreateDTO postCreateDTO) {
        User user = userRepository.findById(postCreateDTO.getUserId()).get();
        Post post = postRepository.save(new Post(postCreateDTO.getTitle(), postCreateDTO.getText(), user));
        return dtoUtils.convertToDto(post, new PostViewDTO(), PostViewDTO.class);
    }


    @Override
    public PostViewDTO updatePost(Long id, PostUpdateDTO postUpdateDTO) {
        if(postRepository.findById(id).isPresent()) {
            Post post = postRepository.findById(id).get();
            post.setId(postUpdateDTO.getId());
            post.setTitle(postUpdateDTO.getTitle());
            post.setText(postUpdateDTO.getText());
            Post updatedPost = postRepository.save(post);
            return dtoUtils.convertToDto(updatedPost, new PostViewDTO(), PostViewDTO.class);
        }else{
            return null;
        }
    }

    @Override
    public void deletePost(Long id) {

        if(postRepository.findById(id).isPresent()) {
            Post post = postRepository.findById(id).get();
            postRepository.deleteById(post.getId());
        }
    }


    @Override
    public List<PostViewDTO> getALlPostByUserId(Long userId) {
        List<Post> list;
        List<PostViewDTO> postViewDTOList = new ArrayList<>();

        if (postRepository.findByUserId(userId).isEmpty()) {
            return null;
        } else {
            list = postRepository.findByUserId(userId);
            list.stream().forEach((p) -> {
                postViewDTOList.add(dtoUtils.convertToDto(p, new PostViewDTO(), PostViewDTO.class));
            });


         postViewDTOList.stream().forEach(System.out::println);
            return postViewDTOList;
        }

    }

    @Override
    public PostViewDTO getPostById(Long id) {
       // Post post = postRepository.findById(id).orElseThrow(() -> new GlobalException("Pas trouvé"));
        Post post = postRepository.findById(id).isPresent()? postRepository.findById(id).get():null;
        System.out.println(post);
        if(post == null){
           return null;
        }else{
            return dtoUtils.convertToDto(post, new PostViewDTO(), PostViewDTO.class);
        }

    }






}