package com.example.demo_cours;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(name = "protected", value = "/protected")
public class ProtectedServlet extends HttpServlet {
    public void init() {

    }

    //do Get avec Cookies
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        boolean logged = false;
//        //Cookie cookie = Arrays.stream(request.getCookies()).filter(c -> c.getName().equals("isLogged")).findFirst().get();
//        Cookie[] cookies = request.getCookies();
//        for(Cookie c : cookies) {
//            if(c.getName().equals("isLogged") && c.getValue().equals("true")) {
//                out.println("<div>Connecté</div>");
//                logged = true;
//                break;
//            }
//        }
//        if(!logged) {
//            out.println("<div>Non connecté</div>");
//        }
//        out.println("</body></html>");
//    }

    //Do Get avec Les sessions
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");


        boolean logged = (session.getAttribute("isLogged") != null) ? (boolean)session.getAttribute("isLogged") : false;
        if(!logged) {
            out.println("<div>Non connecté</div>");
        }
        else {
            out.println("<div>connecté</div>");
        }
        out.println("</body></html>");
    }
}
