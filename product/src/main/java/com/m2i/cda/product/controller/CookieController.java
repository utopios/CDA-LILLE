package com.m2i.cda.product.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("cours-cookie")
public class CookieController {

    @GetMapping("ecrire")
    public String writeCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("data", "Michel");
        cookie.setMaxAge(36000);
        response.addCookie(cookie);

        return "cookie ajouter";
    }

    @GetMapping("ecrire-list")
    public String writeCookieList(HttpServletResponse response) throws JsonProcessingException, UnsupportedEncodingException {

        List<String> liste = Arrays.asList("Karim", "Paul", "Cassandra");
        ObjectMapper mapper = new ObjectMapper();
        String stringListJson = mapper.writeValueAsString(liste);
        Cookie cookie = new Cookie("name", URLEncoder.encode(stringListJson, "UTF-8"));
        cookie.setMaxAge(36000);
        response.addCookie(cookie);

        return "liste cookie ajoutée";
    }

    @GetMapping("lire")
    public String lireCookie(@CookieValue(value = "data") String data, HttpServletRequest request) {
        String info = "";

        for (Cookie c : request.getCookies()) {
            info += c.getValue();
        }
        return info;
    }


}
