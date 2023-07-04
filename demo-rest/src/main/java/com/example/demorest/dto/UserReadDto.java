package com.example.demorest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserReadDto implements UserDto{

    private Integer id;

    private String username;

    private String email;



}
