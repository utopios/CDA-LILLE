package com.example.demo_cours;

import entity.Personne;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "redirection", value = "/redirection-servlet")
public class RedirectionServlet extends HttpServlet {
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Personne personne = new Personne("toto", "tata");
        request.setAttribute("personne", personne);
        request.getRequestDispatcher("redirection.jsp").forward(request, response);
    }



}
