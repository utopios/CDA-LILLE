package com.example.correctionpatient.controller;

import com.example.correctionpatient.entity.Patient;
import com.example.correctionpatient.util.HibernateSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;

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
