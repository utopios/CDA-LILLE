package com.example.demo_cours;


import entities.Produit;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.ProduitService;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "produits", value = "/produits")
public class ProduitServlet extends HttpServlet {


    private ProduitService service;
    public void init() {
        service = new ProduitService();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if(request.getParameter("marque") != null) {
            String marque = request.getParameter("marque");
            String reference = request.getParameter("reference");
            int stock = Integer.parseInt(request.getParameter("stock"));
            double prix = Double.parseDouble(request.getParameter("prix"));
            LocalDate dateAchat = LocalDate.parse(request.getParameter("dateAchat"));
            Produit produit = new Produit(marque, reference, Date.from(dateAchat.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), prix, stock);
            if(service.create(produit)) {
                out.println("<h1>produit ajouté</h1>");
            }
        }else {
            out.println("<h1>erreur de données</h1>");
        }

        out.println("</body></html>");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if(request.getParameter("id") != null) {
            int id = Integer.parseInt((request.getParameter("id")));
            Produit produit = service.findById(id);
            out.println("<h1>Produit </h1>");
            out.println("<div>"+produit+ "</div>");
        }
        else {
            out.println("<h1>Liste des produits</h1>");
            for(Produit p : service.findAll()) {
                out.println("<div>"+p+ "</div>");
            }
        }

        out.println("</body></html>");
    }

    public void destroy() {

    }
}
