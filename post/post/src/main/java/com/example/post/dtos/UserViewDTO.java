package com.example.post.dtos;

import com.example.post.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class UserViewDTO
{
    private  Long id;
    private String userName;



}
