package com.example.correctionpatient.service;

import jakarta.servlet.http.HttpSession;

public class LoginServiceImpl implements LoginService {
    private HttpSession _session;

    public LoginServiceImpl(HttpSession httpSession) {
        _session = httpSession;
    }
    @Override
    public boolean isLogged() {
        return _session.getAttribute("isLogged") != null && (boolean)_session.getAttribute("isLogged") == true;
    }

    @Override
    public boolean login(String user, String password) {
        //je peux utiliser un service Hibernate pour faire la vérification côté base de données.
        if(user.equals("toto") && password.equals("tata")) {
            _session.setAttribute("isLogged", true);
            return true;
        }
        return false;
    }

}
