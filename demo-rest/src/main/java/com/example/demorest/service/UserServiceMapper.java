package com.example.demorest.service;

import com.example.demorest.dto.UserCreateDto;
import com.example.demorest.dto.UserDto;

public interface UserServiceMapper {

    public UserCreateDto createUser(UserCreateDto userDto);

    public UserDto readUser(Integer id);



}
