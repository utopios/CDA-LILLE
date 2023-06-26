package com.example.correctiontodolist.controller;

import com.example.correctiontodolist.service.UserTodoService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;


@Controller
@RequestMapping("user")
public class UserTodoController {

    @Autowired
    private UserTodoService _userTodoService;
    @Autowired
    private HttpServletResponse _response;

    @GetMapping("form")
    public ModelAndView signInForm() {
        ModelAndView mv = new ModelAndView("user-form");
        return mv;
    }

    @PostMapping("sign-in-submit")
    public ModelAndView submitSignIn(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password) throws IOException {
        ModelAndView mv = new ModelAndView("user-form");
        if(_userTodoService.signIn(firstName,lastName, email, password)) {
            _response.sendRedirect("/user/login");
        }
        mv.addObject("firstName", firstName);
        mv.addObject("lastName", lastName);
        mv.addObject("email", email);
        return mv;
    }

    @GetMapping("login")
    public ModelAndView getLogin() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    @PostMapping("login-submit")
    public ModelAndView submitLogin(@RequestParam String email, @RequestParam String password) throws IOException {
        if(_userTodoService.login(email, password)) {
            _response.sendRedirect("/todos-html");
        }
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

}
