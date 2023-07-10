package com.example.post.controllers;

import com.example.post.dtos.UserCreateDTO;
import com.example.post.dtos.UserUpdateDTO;
import com.example.post.dtos.UserViewDTO;
import com.example.post.exceptions.UserExistException;
import com.example.post.exceptions.UserNotFoundException;
import com.example.post.service.interfaces.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    public List<UserViewDTO> listAllUserDto(){
        return userService.listAllUserDto();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserViewDTO> getUserById(@PathVariable Long id){

        if(userService.findUserViewDtoById(id) == null){
            throw new UserNotFoundException("Ressource non trouvé");
        }
        return new ResponseEntity<>(userService.findUserViewDtoById(id), HttpStatus.FOUND);
    }

    @PostMapping("/users")
    public UserViewDTO createUser(@Valid @RequestBody UserCreateDTO userCreateDTO){
        if(userService.findUserByUserNameAndPassword(userCreateDTO.getUserName(), userCreateDTO.getPassword())){
            throw new UserExistException("La combinaison password et mot de passe existe déjà");
        }
        return userService.createUser(userCreateDTO);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserViewDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateDTO userUpdateDTO) {
        if(userService.findUserViewDtoById(id) == null){
            throw new UserNotFoundException("Ressource non trouvé");
        }
      return new ResponseEntity<>(userService.updateUser(id,userUpdateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser( @PathVariable Long id){

        if(userService.findUserViewDtoById(id) == null){
            throw new UserNotFoundException("Ressource non trouvé");
        }

        try{
            userService.deleteUser(id);
            return ResponseEntity.status(204).build();

        }catch (Exception exception){
            throw exception;
        }

    }


}
