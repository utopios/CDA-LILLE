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
        String fileName = extractFileName(part);
        part.write(uploadPath + File.separator + fileName);
        return "images/"+fileName;
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
}
