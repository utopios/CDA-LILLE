package com.example.demorest.controller;

import com.example.demorest.dto.UserCreateDto;
import com.example.demorest.dto.UserDto;

import com.example.demorest.dto.UserReadDto;
import com.example.demorest.service.UserServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class UserControllerMapper {


    @Autowired
  private UserServiceMapper userService;



    @GetMapping("get_user_mapper/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Integer id){


        return new ResponseEntity<>(userService.readUser(id), HttpStatus.OK);

    }




    @PostMapping("created_user_mapper")
    public ResponseEntity<UserReadDto> post(@RequestBody UserCreateDto userCreateDto){

        return new ResponseEntity<UserReadDto>(userService.createUser(userCreateDto), HttpStatus.CREATED);

    }


}













