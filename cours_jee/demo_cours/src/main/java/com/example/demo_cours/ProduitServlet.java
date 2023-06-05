package com.example.demo_cours;


import entities.Produit;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.ProduitService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "produits", value = "/produits")
public class ProduitServlet extends HttpServlet {


    private ProduitService service;
    public void init() {
        service = new ProduitService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Liste des produits</h1>");
        for(Produit p : service.findAll()) {
            out.println("<div>"+p+ "</div>");
        }
        out.println("</body></html>");
    }

    public void destroy() {

    }
}
