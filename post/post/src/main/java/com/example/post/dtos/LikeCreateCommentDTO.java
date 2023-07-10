package com.example.post.dtos;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeCreateCommentDTO {

    private Long id;
    private Long commentId;

    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Le format de date doit être yyyy-MM-dd")
    private String date;
}
