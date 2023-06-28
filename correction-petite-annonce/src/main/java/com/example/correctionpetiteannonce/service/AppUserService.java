package com.example.correctionpetiteannonce.service;

import com.example.correctionpetiteannonce.entity.AppUser;
import com.example.correctionpetiteannonce.exception.UserExistException;
import com.example.correctionpetiteannonce.exception.UserNotActiveException;
import com.example.correctionpetiteannonce.exception.UserNotExistException;
import com.example.correctionpetiteannonce.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
