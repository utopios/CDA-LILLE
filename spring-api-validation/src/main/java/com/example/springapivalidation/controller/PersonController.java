package com.example.springapivalidation.controller;


import com.example.springapivalidation.entity.Person;
import com.example.springapivalidation.service.PersonService;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class PersonController {


    @Autowired
    PersonService personService;

    @PostMapping("/save")
   ResponseEntity<String> createPerson(@Valid @RequestBody Person person){

        personService.save(person);

        return ResponseEntity.ok("Person created");
    }




}
