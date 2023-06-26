package com.example.correctiontodolist.controller;

import com.example.correctiontodolist.service.UrgentTodoService;
import com.example.correctiontodolist.service.UserTodoService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("urgent")
public class TodoUrgentController {

    @Autowired
    private HttpServletResponse _response;
    
    @Autowired
    private UrgentTodoService _urgentTodoService;

    @Autowired
    private UserTodoService _userTodoService;
    
    @GetMapping("add/{id}")
    @ResponseBody
    public void addToUrgent(@PathVariable("id") int id) throws IOException {
        if(_userTodoService.isLogged()) {
            if(_urgentTodoService.addToUrgent(id)) {
                _response.sendRedirect("/todos-html/detail/"+id);
            }
            //Redirection vers une page d'erreur si la todo ne peut pas être ajouter
        }
        else {
            _response.sendRedirect("/user/login");
        }
    }

    @GetMapping("remove/{id}")
    @ResponseBody
    public void removeToUrgent(@PathVariable("id") int id) throws IOException {
        if(_userTodoService.isLogged()) {
            if(_urgentTodoService.removeFromUrgent(id)) {
                _response.sendRedirect("/todos-html/detail/"+id);
            }
            //Redirection vers une page d'erreur si la todo ne peut pas être ajouter
        }
        else {
            _response.sendRedirect("/user/login");
        }
    }

    @GetMapping("")
    public ModelAndView displayUrgent() throws IOException {
        if(!_userTodoService.isLogged()) {
            _response.sendRedirect("/user/login");

        }
        ModelAndView vm = new ModelAndView("home");
        vm.addObject("todos", _urgentTodoService.getUrgentsTodo());
        return vm;
    }
}
