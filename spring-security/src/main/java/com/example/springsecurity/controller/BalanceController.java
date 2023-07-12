package com.example.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {



    @GetMapping("/myBalance")
    public String getAccountDetails(){
        return "Balances details";
    }


}
