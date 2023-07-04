package com.example.demorest.service;

import com.example.demorest.dto.UserCreateDto;
import com.example.demorest.dto.UserDto;
import com.example.demorest.dto.UserReadDto;

public interface UserServiceMapper {

    public UserReadDto createUser(UserCreateDto userDto);

    public UserDto readUser(Integer id);



}
