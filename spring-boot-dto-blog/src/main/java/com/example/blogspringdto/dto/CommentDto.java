package com.example.blogspringdto.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CommentDto {

    private long id;

    //validations for resource
    //name should not be null or empty
    //name should have at least 2 characters
    @NotEmpty(message = "Name should not be null or empty")
    @Size(min = 2, message = "Name should have min. 2 characters")
    private String name;

    //email should not be null or empty
    //email field validation
    @NotEmpty(message = "Email should not be null or empty")
    @Email
    private String email;


    private Date date;

    //comment body should not be null or empty
    //comment body must be min. 10 characters
    @NotEmpty(message = "Comment body should not be null or empty")
    @Size(min = 10, message = "Comment body should have min. 10 characters")
    private String body;


}
