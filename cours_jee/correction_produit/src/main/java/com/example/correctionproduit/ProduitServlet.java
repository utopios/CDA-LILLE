package com.example.correctionproduit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@WebServlet(name = "produits", value = "/produits")
public class ProduitServlet extends HttpServlet {


    private services.ProduitService service;
    public void init() {
        service = new services.ProduitService();
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
            entities.Produit produit = new entities.Produit(marque, reference, Date.from(dateAchat.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), prix, stock);
            if(service.create(produit)) {
                out.println("<h1>produit ajouté</h1>");
            }
        }else {
            out.println("<h1>erreur de données</h1>");
        }

        out.println("</body></html>");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if(request.getParameter("id") != null) {
            int id = Integer.parseInt((request.getParameter("id")));
            entities.Produit produit = service.findById(id);
            request.setAttribute("produit", produit);
            request.getRequestDispatcher("produit.jsp").forward(request,response);
        }
        else {
            request.setAttribute("produits", service.findAll());
            request.getRequestDispatcher("produits.jsp").forward(request,response);
        }

    }

    public void destroy() {

    }
}
