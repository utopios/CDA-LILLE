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
        Part image = request.getPart("image");
        String fileName = image.getSubmittedFileName();
        String uploadPath =  getServletContext().getRealPath("/") + "images";



        File uploadDir = new File(uploadPath);
        if(!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        image.write(uploadPath + File.separator + fileName);
        request.getRequestDispatcher("form-upload.jsp").forward(request, response);
    }
}
