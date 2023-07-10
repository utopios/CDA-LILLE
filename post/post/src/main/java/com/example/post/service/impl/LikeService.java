package com.example.post.service.impl;


import com.example.post.dtos.LikeCreateCommentDTO;
import com.example.post.dtos.LikeViewDTO;
import com.example.post.entities.Comment;
import com.example.post.entities.Like;
import com.example.post.repositories.CommentRepository;
import com.example.post.repositories.LikeRepository;
import com.example.post.repositories.PostRepository;
import com.example.post.utils.ConvertDate;
import com.example.post.utils.DtoUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LikeService implements com.example.post.service.interfaces.LikeService
{

    @Autowired
    private  LikeRepository likeRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private DtoUtils dtoUtils;

    @Autowired
    private ConvertDate convertDate;

    @Override
    public LikeViewDTO createLikeComment(LikeCreateCommentDTO likeCreateCommentDTO)  {
        Comment comment;
        Date date;
        if(!commentRepository.findById(likeCreateCommentDTO.getCommentId()).isPresent()){
            return null;
        }else{
            date =  convertDate.convertDate(likeCreateCommentDTO.getDate());

            comment = commentRepository.findById(likeCreateCommentDTO.getCommentId()).get();
           Like like = likeRepository.save(new Like(comment, date));
           return dtoUtils.convertToDto(like, new LikeViewDTO(), LikeViewDTO.class);
        }

    }



    @Override
    public void delete(Long id) {
        Like like= likeRepository.findById(id).orElseThrow();
        likeRepository.deleteById(like.getId());
    }

    @Override
    public List<LikeViewDTO> getAllLikesByCommentId( Optional<Long> postId) {
        List<LikeViewDTO> list;
        if(likeRepository.findByCommentId(postId.get()).isEmpty()){
            return null;
        }else{
            return likeRepository.findByCommentId(postId.get()).stream().map(like -> dtoUtils.convertToDto(like, new LikeViewDTO(), LikeViewDTO.class)).collect(Collectors.toList());
        }

    }




}