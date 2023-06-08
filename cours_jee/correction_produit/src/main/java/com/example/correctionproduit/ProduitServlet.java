package com.example.correctionproduit;

import com.example.entities.Image;
import com.example.services.UploadService;
import com.example.util.Definition;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@WebServlet(name = "produits", value = "/produits")
@MultipartConfig(
        //taille max d'un fichier
        maxFileSize = 1024*1024*10,
        //taille max d'une requete
        maxRequestSize = 1024*1024*100
)
public class ProduitServlet extends HttpServlet {


    private services.ProduitService service;

    private UploadService uploadService;
    public void init() {
        service = new services.ProduitService();
        uploadService = new UploadService(getServletContext());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        if(request.getParameter("marque") != null) {
            String marque = request.getParameter("marque");
            String reference = request.getParameter("reference");
            int stock = Integer.parseInt(request.getParameter("stock"));
            double prix = Double.parseDouble(request.getParameter("prix"));
            LocalDate dateAchat = LocalDate.parse(request.getParameter("dateAchat"));
            entities.Produit produit = new entities.Produit(marque, reference, Date.from(dateAchat.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), prix, stock);
            for(Part part : request.getParts()) {
                if(part.getName().equals("images")) {
                    Image image = new Image();
                    String url = uploadService.Upload(part);
                    image.setUrl(url);
                    image.setProduit(produit);
                    produit.getImages().add(image);
                }

            }
            if(service.create(produit)) {
                response.sendRedirect("produits");
            }
        }else {

        }


    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if(request.getParameter("id") != null) {
            int id = Integer.parseInt((request.getParameter("id")));
            entities.Produit produit = service.findById(id);
            request.setAttribute("produit", produit);
            request.getRequestDispatcher(Definition.VIEW_PATH+"produit.jsp").forward(request,response);
        }
        else {
            request.setAttribute("produits", service.findAll());
            request.getRequestDispatcher(Definition.VIEW_PATH+"produits.jsp").forward(request,response);
        }

    }

    public void destroy() {

    }
}
