package com.example.springsecurity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDto {

    private String token;
    private Integer id;
    private String name;
    private String role;

}
