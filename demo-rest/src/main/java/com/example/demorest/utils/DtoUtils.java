package com.example.demorest.utils;

import com.example.demorest.dto.UserDto;
import com.example.demorest.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DtoUtils {


    public UserDto convertToDto(User user, UserDto userDto) {
        return new ModelMapper().map(user, userDto.getClass());
    }

    public User convertToEntity(User user, UserDto userDto) {
        return new ModelMapper().map(userDto, user.getClass());
    }


}
