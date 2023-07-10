package com.example.post.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Data
@AllArgsConstructor
public class PostCreateDTO {
    private Long id;

    @Size(min = 4, max=15)
    @NotEmpty(message = "Le titre ne peut être null")
    private String title;

    @Size(max = 250)
    @NotEmpty(message = "Le texte ne peut être null")
    private String text;

    private Long userId;
}
