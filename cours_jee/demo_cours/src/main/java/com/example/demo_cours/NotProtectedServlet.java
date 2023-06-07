package com.example.demo_cours;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "notprotected", value = "/notprotected")
public class NotProtectedServlet extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("isLogged", "true");
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
    }
}
