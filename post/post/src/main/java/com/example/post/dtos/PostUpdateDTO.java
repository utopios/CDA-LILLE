package com.example.post.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostUpdateDTO {

    private Long id;

    @Size(min = 3, max = 250)
    @NotEmpty(message = "title cannot be null")
    private String title;

    @Size(min = 3, max = 450)
    @NotEmpty(message = "text cannot be null")
    private String text;

}
