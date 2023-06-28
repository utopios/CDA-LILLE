package com.example.correctionpetiteannonce.controller;


import com.example.correctionpetiteannonce.exception.UserExistException;
import com.example.correctionpetiteannonce.exception.UserNotExistException;
import com.example.correctionpetiteannonce.service.AppUserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private AppUserService appUserService;
    @Autowired
    private HttpServletResponse response;

    @GetMapping("signin")
    public ModelAndView signIn() {
        ModelAndView mv = new ModelAndView("signin");
        return mv;
    }

    @PostMapping("signin")
    public String signUp(@RequestParam String email, @RequestParam String password) throws UserNotExistException, IOException {
        if(appUserService.signIn(email, password)) {
            return "redirect:/";
        }
        return null;
    }

    @ExceptionHandler(UserNotExistException.class)
    public ModelAndView handleUserNotExist(UserNotExistException ex) {
        ModelAndView mv = new ModelAndView("signin");
        mv.addObject("message", ex.getMessage());
        return mv;
    }

    @GetMapping("signup")
    public ModelAndView postSignIn() {
        ModelAndView mv = new ModelAndView("signup");
        return mv;
    }

    @PostMapping("signup")
    public String postSignUp(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password) throws UserExistException, IOException {
        if(appUserService.signUp(firstName, lastName, email, password)) {
            return "redirect:/user/signin";
        }
        return null;
    }

    @ExceptionHandler(UserExistException.class)
    public ModelAndView handleUserExist(UserExistException ex) {
        ModelAndView mv = new ModelAndView("signup");
        mv.addObject("message", ex.getMessage());
        return mv;
    }
}
