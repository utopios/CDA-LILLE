package com.example.blogspringdto.utils;

import com.example.blogspringdto.dto.CommentDto;
import com.example.blogspringdto.dto.PostDto;
import com.example.blogspringdto.entity.Comment;
import com.example.blogspringdto.entity.Post;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Mapper {



    //convert entity to dto
    public PostDto mapToDto(Post post) {

        ModelMapper mapper = new ModelMapper();
        //map with modelMapper lib.
        PostDto postDto = mapper.map(post, PostDto.class);
        return postDto;

    }

    //convert dto to entity
    public Post mapToEntity(PostDto postDto) {
        ModelMapper mapper = new ModelMapper();
        //map with modelMapper lib.
        Post post = mapper.map(postDto, Post.class);

        return post;
    }

    public CommentDto mapToDto(Comment comment) {

        ModelMapper mapper = new ModelMapper();
        CommentDto commentDto = mapper.map(comment, CommentDto.class);

        return commentDto;

    }

    //convert dto to entity
    public Comment mapToEntity(CommentDto commentDto) {

        ModelMapper mapper = new ModelMapper();
        Comment comment = mapper.map(commentDto, Comment.class);

        return  comment;


    }


}
