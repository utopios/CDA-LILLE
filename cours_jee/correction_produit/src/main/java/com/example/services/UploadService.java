package com.example.services;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

public class UploadService {

    private String uploadPath;
    private ServletContext _context;
    public  UploadService(ServletContext context) {
        _context = context;
        uploadPath =  _context.getRealPath("/") + "images";
        File uploadDir = new File(uploadPath);
        if(!uploadDir.exists()) {
            uploadDir.mkdir();
        }
    }

    public String Upload(Part part) throws IOException {
        String fileName = part.getSubmittedFileName();
        part.write(uploadPath + File.separator + fileName);
        return "images/"+fileName;
    }
}
