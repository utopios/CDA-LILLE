package com.example.correctionpatient.controller;

import com.example.correctionpatient.entity.Patient;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.example.correctionpatient.util.Definition.VIEW_PATH;

@WebServlet(name = "patient", value = "/")
public class PatientServlet extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher(VIEW_PATH + "/patients.jsp").forward(request, response);
    }
}
