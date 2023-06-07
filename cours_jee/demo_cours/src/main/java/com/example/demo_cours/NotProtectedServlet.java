package com.example.demo_cours;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name = "notprotected", value = "/notprotected")
public class NotProtectedServlet extends HttpServlet {

    public void init() {

    }

    //Pour écrire dans des cookies
//    public void doGet(HttpServletRequest request, HttpServletResponse response) {
//        Cookie cookie = new Cookie("isLogged", "true");
//        cookie.setMaxAge(60*60);
//        response.addCookie(cookie);
//    }

    //Pour écrire dans des sessions
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute("isLogged", true);
    }
}
