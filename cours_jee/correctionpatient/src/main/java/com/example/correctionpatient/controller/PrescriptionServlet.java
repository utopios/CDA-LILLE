package com.example.correctionpatient.controller;

import com.example.correctionpatient.service.FicheSoinsService;
import com.example.correctionpatient.service.PrescriptionService;
import com.example.correctionpatient.util.Definition;
import com.example.correctionpatient.util.HibernateSession;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "prescription", value = "/prescription")
public class PrescriptionServlet extends HttpServlet {
    private PrescriptionService prescriptionService;

    public void init() {
        prescriptionService = new PrescriptionService(HibernateSession.getSessionFactory());
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if(request.getParameter("consultationId") != null && !request.getParameter("consultationId").equals("") && !request.getParameter("content").equals("")) {
            int consultationId = Integer.parseInt(request.getParameter("consultationId"));
            if(prescriptionService.createPrescription(consultationId, request.getParameter("content"))) {
                response.sendRedirect(Definition.BASE_URL+"/consultation?id="+consultationId);
            }
        }
    }
}
