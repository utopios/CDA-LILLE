package com.example.demo_cours;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "protected", value = "/protected")
public class ProtectedServlet extends HttpServlet {
    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        Cookie[] cookies = request.getCookies();
        boolean logged = false;
        for(Cookie c : cookies) {
            if(c.getName().equals("isLogged") && c.getValue().equals("true")) {
                out.println("<div>Connecté</div>");
                logged = true;
                break;
            }
        }
        if(!logged) {
            out.println("<div>Non connecté</div>");
        }
        out.println("</body></html>");
    }
}
