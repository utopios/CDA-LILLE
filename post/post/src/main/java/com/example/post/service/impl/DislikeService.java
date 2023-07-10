package com.example.post.service.impl;


import com.example.post.dtos.*;
import com.example.post.entities.*;
import com.example.post.repositories.*;
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
public class DislikeService implements com.example.post.service.interfaces.DislikeService {

    @Autowired
    private DislikeRepository dislikeRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private DtoUtils dtoUtils;
    @Autowired
    private ConvertDate convertDate;

    @Override
    public DislikeViewDTO  createDislikeComment(DislikeCreateCommentDTO  dislikeCreateCommentDTO) {
        Comment comment ;
        Date date;
        if(!commentRepository.findById(dislikeCreateCommentDTO.getCommentId()).isPresent()){
            return null;
        }else{

            date =  convertDate.convertDate(dislikeCreateCommentDTO.getDate());
            comment = commentRepository.findById(dislikeCreateCommentDTO.getCommentId()).get();
            Dislike dislike = dislikeRepository.save(new Dislike(comment, date));
            return dtoUtils.convertToDto(dislike, new DislikeViewDTO(), DislikeViewDTO.class);
        }

    }



    @Override
    public void delete(Long id) {
        Dislike dislike;
        if(dislikeRepository.findById(id).isPresent()){
            dislike = dislikeRepository.findById(id).get();
            dislikeRepository.deleteById(dislike.getId());
        }

    }

    @Override
    public List<DislikeViewDTO> getAllLikesByCommentId( Optional<Long> comentId) {
        List<DislikeViewDTO> list;
        if(dislikeRepository.findByCommentId(comentId.get()).isEmpty()){
            return null;
        }else{
            return dislikeRepository.findByCommentId(comentId.get()).stream().map(dislike -> dtoUtils.convertToDto(dislike, new DislikeViewDTO(), DislikeViewDTO.class)).collect(Collectors.toList());
        }

    }
}
