package com.example.demo_cours;

import entity.Personne;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "redirection", value = "/redirection-servlet")
public class RedirectionServlet extends HttpServlet {
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Personne> personnes = new ArrayList<>();
        Personne personne = new Personne("toto", "tata");
        personnes.add(personne);
        request.setAttribute("personne", personne);
        request.setAttribute("personnes", personnes);
        request.getRequestDispatcher("redirection.jsp").forward(request, response);
    }



}
