package com.example.correctionpatient.service;

public interface LoginService {

    public boolean isLogged();

    public boolean login(String user, String password);
}
