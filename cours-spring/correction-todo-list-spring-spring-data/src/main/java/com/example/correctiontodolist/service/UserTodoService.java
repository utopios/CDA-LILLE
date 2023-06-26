package com.example.correctiontodolist.service;

import com.example.correctiontodolist.entity.UserTodo;
import com.example.correctiontodolist.repository.UserTodoRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTodoService {

    @Autowired
    private HttpSession _httpSession;
    @Autowired
    private UserTodoRepository _userTodoRepository;

    public boolean signIn(String firstName, String lastName, String email, String password) {
        if(!searchByEmail(email))  {
            //On peut appliquer des vérifications sur les champs firstName,...
            UserTodo user = UserTodo.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    //Hash du password
                    .password(password)
                    .email(email)
                    .build();
            if(_userTodoRepository.save(user) != null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean login(String email, String password) {
        UserTodo userTodo = _userTodoRepository.findByEmail(email);
        if(userTodo != null && userTodo.getPassword().equals(password)) {
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

    public boolean searchByEmail(String email) {
        return _userTodoRepository.findByEmail(email) != null;
    }
}
