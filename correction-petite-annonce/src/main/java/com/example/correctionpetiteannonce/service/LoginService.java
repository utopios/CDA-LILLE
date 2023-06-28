package com.example.correctionpetiteannonce.service;

import com.example.correctionpetiteannonce.entity.AppUser;

public interface LoginService {

    public boolean login(AppUser user);
    public boolean isLogged();

    public boolean isAdmin();

    public int getUserId();

}
