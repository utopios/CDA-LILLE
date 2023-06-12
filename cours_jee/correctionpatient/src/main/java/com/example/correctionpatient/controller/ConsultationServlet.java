package com.example.correctionpatient.controller;

import com.example.correctionpatient.entity.Consultation;
import com.example.correctionpatient.service.ConsultationService;
import com.example.correctionpatient.util.Definition;
import com.example.correctionpatient.util.HibernateSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "consultations", value = "/consultation")
public class ConsultationServlet extends HttpServlet {
    private ConsultationService consultationService;

    public void init() {
        consultationService = new ConsultationService(HibernateSession.getSessionFactory());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("id") != null && !request.getParameter("id").equals("")) {
            int consultationId = Integer.parseInt(request.getParameter("id"));
            Consultation consultation = consultationService.getByIdConsultation(consultationId);
            request.setAttribute("consultation", consultation);
            request.getRequestDispatcher(Definition.VIEW_PATH + "/consultation.jsp").forward(request, response);
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if(request.getParameter("patientId") != null && !request.getParameter("patientId").equals("")) {
            int patientId = Integer.parseInt(request.getParameter("patientId"));
            if(consultationService.createConsultation(patientId)) {
                response.sendRedirect(Definition.BASE_URL+"/?id="+patientId);
            }
        }
    }
}
