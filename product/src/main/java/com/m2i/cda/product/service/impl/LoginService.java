package com.m2i.cda.product.service.impl;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final String SAMPLE_LOGIN = "test@test.fr";
    private final String SAMPLE_PASSWORD = "123456789";

    @Autowired
    private HttpSession _httpSession;

    public boolean login(String email, String password) {
        if(email.equals(SAMPLE_LOGIN) && password.equals(SAMPLE_PASSWORD)) {
            _httpSession.setAttribute("isLogged", "OK");
            return true;
        }
        return false;
    }

    public boolean isLogged() {
        try {
            String attrIsLogged = _httpSession.getAttribute("isLogged").toString();
            return attrIsLogged.equals("OK");
        }catch (Exception ex) {
            return false;
        }
    }
}
