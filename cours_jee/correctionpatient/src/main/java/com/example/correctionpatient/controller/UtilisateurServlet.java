package com.example.correctionpatient.controller;

import com.example.correctionpatient.service.LoginService;
import com.example.correctionpatient.service.LoginServiceImpl;
import com.example.correctionpatient.util.Definition;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "utilisateur", value = "/utilisateur")
public class UtilisateurServlet extends HttpServlet {


    private LoginService loginService;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("action") != null && request.getParameter("action").equals("login")) {
            request.getRequestDispatcher(Definition.VIEW_PATH + "/login.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        loginService = new LoginServiceImpl(request.getSession());
        if(request.getParameter("action") != null && request.getParameter("action").equals("login") && !request.getParameter("login").equals("") && !request.getParameter("password").equals("")) {
            if(loginService.login(request.getParameter("login"),request.getParameter("password"))) {
                response.sendRedirect(Definition.BASE_URL);
            }
            else {
                request.setAttribute("messageError", "Erreur de login");
                request.getRequestDispatcher(Definition.VIEW_PATH + "/login.jsp").forward(request, response);
            }

        }
    }
}
