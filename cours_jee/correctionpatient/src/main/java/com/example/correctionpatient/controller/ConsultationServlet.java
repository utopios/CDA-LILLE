package com.example.correctionpatient.controller;

import com.example.correctionpatient.service.ConsultationService;
import com.example.correctionpatient.util.Definition;
import com.example.correctionpatient.util.HibernateSession;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "consultations", value = "/consultation")
public class ConsultationServlet extends HttpServlet {
    private ConsultationService consultationService;

    public void init() {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        consultationService = new ConsultationService(HibernateSession.getSessionFactory());
        if(request.getParameter("patientId") != null && !request.getParameter("patientId").equals("")) {
            int patientId = Integer.parseInt(request.getParameter("patientId"));
            if(consultationService.createConsultation(patientId)) {
                response.sendRedirect(Definition.BASE_URL+"/?id="+patientId);
            }
        }
    }
}
