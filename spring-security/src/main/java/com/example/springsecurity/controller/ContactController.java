package com.example.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {



    @GetMapping("/contact")
    public String getAccountDetails(){
        return "Liste des contacts";
    }


}
