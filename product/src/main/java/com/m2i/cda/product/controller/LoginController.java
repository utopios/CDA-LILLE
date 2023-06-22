package com.m2i.cda.product.controller;

import com.m2i.cda.product.service.impl.LoginService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("tp-login")
public class LoginController {

    @Autowired
    private LoginService _loginService;

    @Autowired
    private HttpServletResponse _response;

    @GetMapping("login")
    public ModelAndView getLogin() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    @PostMapping("submit")
    public ModelAndView submitLogin(@RequestParam String login, @RequestParam String password) throws IOException {
        if(_loginService.login(login, password)) {
            _response.sendRedirect("protected");
        }
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    @GetMapping("protected")
    @ResponseBody
    public String protectedPage() throws IOException {
        if(!_loginService.isLogged()){
            _response.sendRedirect("login");
        }
        return "protected";
    }



}
