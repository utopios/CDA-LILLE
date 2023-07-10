package com.example.post.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
public class CommentCreateDTO {
    private Long id;

    @NotEmpty
    @Size(min = 3, max = 250)
    private String text;

    private Long postId;
}
