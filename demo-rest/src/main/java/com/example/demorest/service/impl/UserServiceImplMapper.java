package com.example.demorest.service.impl;

import com.example.demorest.dto.UserCreateDto;
import com.example.demorest.dto.UserDto;
import com.example.demorest.dto.UserReadDto;
import com.example.demorest.entity.User;
import com.example.demorest.repository.UserRepository;
import com.example.demorest.service.UserServiceMapper;
import com.example.demorest.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplMapper implements UserServiceMapper {



    @Autowired
    private DtoUtils dtoUtils;

    @Autowired
    UserRepository userRepository;


    @Override
    public UserReadDto createUser(UserCreateDto userDto) {

        User user = dtoUtils.convertToEntity(new User(), userDto);

        User user1 = userRepository.save(user);

        return (UserReadDto) dtoUtils.convertToDto(user1, new UserReadDto());
    }



    @Override
    public UserDto readUser(Integer id) {

        return dtoUtils.convertToDto(userRepository.findById(id).get(), new UserReadDto());
    }
}
