package com.example.demo_cours;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@WebServlet(name = "upload", value = "/upload")
@MultipartConfig(
        //taille max d'un fichier
        maxFileSize = 1024*1024*10,
        //taille max d'une requete
        maxRequestSize = 1024*1024*100
)
public class UploadServlet extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("form-upload.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Le dossier ou sera envoyer le fichier, getServletContext => permet de récupérer le dossier de deploiement des servlet
        String uploadPath =  getServletContext().getRealPath("/") + "images";


        //Créer le dossier d'upload s'il n'existe pas
        File uploadDir = new File(uploadPath);
        if(!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        //Le fichier envoyé par le client
        //Part image = request.getPart("image");

        //On peut récupérer, par exemple, le nom du fichier
        //String fileName = image.getSubmittedFileName();



        //On crée notre fichier dans le dossier upload à partir du fichier récupéré
        //image.write(uploadPath + File.separator + fileName);

        //SI un envoie multiple

        for(Part part : request.getParts()) {
            String name = part.getSubmittedFileName();
            part.write(uploadPath + File.separator + name);
        }
        request.getRequestDispatcher("form-upload.jsp").forward(request, response);
    }
}
