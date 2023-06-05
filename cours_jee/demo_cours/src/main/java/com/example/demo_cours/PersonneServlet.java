package com.example.demo_cours;

import entity.Personne;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "personne", value = "/personne")
public class PersonneServlet extends HttpServlet {

    private List<Personne> personneList;
    public void init() {
        personneList = new ArrayList<>();
        personneList.add(new Personne("tata", "toto"));
        personneList.add(new Personne("minet", "titi"));
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Liste des personnes</h1>");
        for(Personne p : personneList) {
            out.println("<div>"+p.getNom() +" " + p.getPrenom() + "</div>");
        }
        out.println("</body></html>");
    }

    public void destroy() {

    }
}
