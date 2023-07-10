package com.example.post.service.impl;

import com.example.post.exceptions.GlobalException;
import com.example.post.service.interfaces.IUserService;
import com.example.post.dtos.UserCreateDTO;
import com.example.post.dtos.UserUpdateDTO;
import com.example.post.dtos.UserViewDTO;
import com.example.post.entities.User;
import com.example.post.repositories.UserRepository;
import com.example.post.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {


    @Autowired
    DtoUtils dtoUtils;

    @Autowired
    UserRepository userRepository;

    public UserViewDTO createUser(UserCreateDTO user) {

        User user1 = dtoUtils.convertToDto(user, new User(), User.class);

        User user2 = userRepository.save(user1);

        return dtoUtils.convertToDto(user2, new UserViewDTO(), UserViewDTO.class);

    }


    @Override
    public List<UserViewDTO> listAllUserDto() {
        List<UserViewDTO> liste = new ArrayList<>();
        userRepository.findAll().stream().forEach(user -> {
            liste.add(dtoUtils.convertToDto(user, new UserViewDTO(), UserViewDTO.class));
        });
        return liste;

    }

    public void deleteUser(Long id) {
        if(!userRepository.findById(id).isEmpty()) {
            userRepository.findById(id).get().getPosts().stream().forEach(post -> {
                post.setUser(null);
            });
            userRepository.deleteById(id);
        }

    }

    public UserViewDTO findUserViewDtoById(Long id) {
        return dtoUtils.convertToDto(userRepository.findById(id).orElseThrow(()->new GlobalException("Ressource non trouvé")), new UserViewDTO(), UserViewDTO.class);
    }

    @Override
    public Boolean findUserByUserNameAndPassword(String userName, String password) {

        return userRepository.findByUserNameAndPassword(userName,password) != null ? true : false;
    }


    public UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        if (userRepository.findById(id).isEmpty()) {
            return null;
        } else {
            userUpdateDTO.setId(id);
            User user = dtoUtils.convertToDto(userUpdateDTO, new User(), User.class);
            userRepository.save(user);
            return dtoUtils.convertToDto(user, new UserViewDTO(), UserViewDTO.class);
        }
    }



}
