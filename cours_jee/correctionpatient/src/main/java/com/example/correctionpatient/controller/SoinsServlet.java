package com.example.correctionpatient.controller;

import com.example.correctionpatient.service.FicheSoinsService;
import com.example.correctionpatient.util.Definition;
import com.example.correctionpatient.util.HibernateSession;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "soins", value = "/soins")
public class SoinsServlet extends HttpServlet {
    private FicheSoinsService ficheSoinsService;

    public void init() {
        ficheSoinsService = new FicheSoinsService(HibernateSession.getSessionFactory());
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if(request.getParameter("consultationId") != null && !request.getParameter("consultationId").equals("") && !request.getParameter("content").equals("")) {
            int consultationId = Integer.parseInt(request.getParameter("consultationId"));
            if(ficheSoinsService.createSoins(consultationId, request.getParameter("content"))) {
                response.sendRedirect(Definition.BASE_URL+"/consultation?id="+consultationId);
            }
        }
    }
}
