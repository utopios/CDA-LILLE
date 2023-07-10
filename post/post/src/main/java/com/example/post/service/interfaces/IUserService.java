package com.example.post.service.interfaces;


import com.example.post.dtos.UserCreateDTO;
import com.example.post.dtos.UserUpdateDTO;
import com.example.post.dtos.UserViewDTO;

import java.util.List;

public interface IUserService {

    UserViewDTO createUser(UserCreateDTO userCreateDTO);
    UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO);
    void deleteUser(Long id);
    List<UserViewDTO> listAllUserDto();

    UserViewDTO findUserViewDtoById(Long id);

    Boolean findUserByUserNameAndPassword(String userName, String password);


}
