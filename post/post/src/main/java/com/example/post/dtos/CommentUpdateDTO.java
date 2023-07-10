package com.example.post.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Data
@AllArgsConstructor
public class CommentUpdateDTO {

    private Long id;

    @NotEmpty
    @Size(min = 3, max = 250)
    private String text;
}
