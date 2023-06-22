package com.m2i.cda.product.controller;

import com.m2i.cda.product.service.impl.ColorService;
import jakarta.servlet.http.Cookie;
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
@RequestMapping("cookie-color")
public class ColorCookieController {

    @Autowired
    private ColorService _colorService;
    @GetMapping("form")
    public ModelAndView get() {

        String color = "";

        ModelAndView vm = new ModelAndView("cookie-color");

        if(_colorService.getColor()==null){
            color = "red";
            vm.addObject("color", color);
        }else{
            vm.addObject("color", _colorService.getColor());
        }
        return vm;
    }
    @PostMapping("submit")
    public void post(@RequestParam String color, HttpServletResponse response) throws IOException {

        Cookie cookie = new Cookie("color", color);
        cookie.setMaxAge(7*24*3600);
        response.addCookie(cookie);
        response.sendRedirect("/cookie-color/form");

    }
}
