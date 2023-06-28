package com.example.correctionpetiteannonce.service;

import com.example.correctionpetiteannonce.entity.AppUser;
import com.example.correctionpetiteannonce.exception.*;
import com.example.correctionpetiteannonce.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private LoginService loginService;

    public boolean signUp(String firstName, String lastName, String email, String password) throws UserExistException {
        try {
            appUserRepository.findByEmail(email);
            throw new UserExistException();
        }
        catch (Exception ex) {
            AppUser user = AppUser.builder().firstName(firstName).lastName(lastName).email(email).password(password).build();
            appUserRepository.save(user);
            return user.getId() > 0;
        }
    }

    public boolean signIn(String email, String password) throws UserNotExistException {
        try {
            AppUser user = appUserRepository.findByEmailAndPassword(email, password);
            if(user.isActive()) {
                return loginService.login(user);
            }
            throw new UserNotActiveException();
        }catch (Exception ex) {
            throw new UserNotExistException();
        }
    }

    public List<AppUser> getUsers() throws NotSignInException, NotAdminException {
        if(loginService.isLogged()) {
            if(loginService.isAdmin()) {
                return (List<AppUser>)appUserRepository.findAll();
            }
            throw new NotAdminException();
        }
        throw new NotSignInException();
    }

    public boolean disableUser(int userId) throws NotAdminException, NotSignInException, UserNotExistException {
        if(loginService.isLogged()) {
            if(loginService.isAdmin()) {
                try {
                    AppUser user = appUserRepository.findById(userId).get();
                    user.setActive(false);
                    appUserRepository.save(user);
                    return true;
                }catch (Exception ex) {
                    throw new UserNotExistException();
                }
            }
            throw new NotAdminException();
        }
        throw new NotSignInException();
    }
}
