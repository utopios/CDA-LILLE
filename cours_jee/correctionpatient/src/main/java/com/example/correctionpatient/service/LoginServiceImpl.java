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

}
