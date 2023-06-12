package com.example.correctionpatient.controller;

import com.example.correctionpatient.entity.Patient;
import com.example.correctionpatient.service.PatientService;
import com.example.correctionpatient.util.HibernateSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;

import java.io.IOException;
import java.util.List;

import static com.example.correctionpatient.util.Definition.VIEW_PATH;

@WebServlet(name = "patient", value = "/")
public class PatientServlet extends HttpServlet {
    private PatientService patientService;
    private List<Patient> patients;
    public void init() {
        patientService = new PatientService(HibernateSession.getSessionFactory());

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String messageError = null;
        if(request.getParameter("action").equals("search")) {
            patients = patientService.getPatients(request.getParameter("search"));
        }
        else {
            patients = patientService.getPatients(null);
            if(!request.getParameter("name").equals("") && !request.getParameter("phone").equals("")) {
                String name= request.getParameter("name");
                String phone = request.getParameter("phone");
                if(patientService.createPatient(name, phone)) {
                    response.sendRedirect("");
                }else {
                    messageError = "Erreur d'ajout";
                }
            }
            else {
                messageError = "Merci de saisir les deux champs";
            }
        }
        if(messageError != null || request.getParameter("action").equals("search")) {
            request.setAttribute("patients", patients);
            request.setAttribute("messageError", messageError);
            request.getRequestDispatcher(VIEW_PATH + "/patients.jsp").forward(request, response);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        patients = patientService.getPatients(null);
        request.setAttribute("patients", patients);
        request.getRequestDispatcher(VIEW_PATH + "/patients.jsp").forward(request, response);
    }
}
