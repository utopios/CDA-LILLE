package com.example.post.dtos;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class DislikeCreateCommentDTO {

    private Long id;

    private Long commentId;

    @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}", message = "Le format de date doit être dd-MM-yyyy")
    private String date;
}
