package com.example.correctiontodolist.controller;

import com.example.correctiontodolist.entity.Todo;
import com.example.correctiontodolist.service.TodoService;
import com.example.correctiontodolist.service.UrgentTodoService;
import com.example.correctiontodolist.service.UserTodoService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Ce contrôleur est à utiliser uniquement avec les vues en html en tyemleaf
@Controller
@RequestMapping("todos-html")
public class TodoWithViewController {
    @Autowired
    private TodoService todoService;

    @Autowired
    private UserTodoService _userTodoService;

    @Autowired
    private UrgentTodoService _urgentTodoService;

    @Autowired
    private HttpServletResponse response;

    @GetMapping(value = {"","{status}"})
    public ModelAndView getTodos(@PathVariable(required = false) Boolean status) {
        ModelAndView mv = new ModelAndView("home");
        List<Todo> todos = new ArrayList<>();
        if(status == null) {
            todos.addAll(todoService.getByStatus(false));
            todos.addAll(todoService.getByStatus(true));
        }
        else {
            todos.addAll(todoService.getByStatus(status));
        }
        mv.addObject("todos", todos);
        return mv;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView getDetail(@PathVariable Integer id) {
        ModelAndView mv = new ModelAndView("detail");
        mv.addObject("todo", todoService.getTodoById(id));
        mv.addObject("isLogged", _userTodoService.isLogged());
        mv.addObject("isUrgent", _urgentTodoService.isUrgent(id));
        return mv;
    }

    @GetMapping("/update/{id}")
    public Object updapteStatus(@PathVariable Integer id) throws Exception {
        if(_userTodoService.isLogged()) {
            try {
                todoService.updateStatus(id);
                //response.sendRedirect("/todos-html/detail/"+id);
                return "redirect:/todos-html/detail/"+id;
            }catch (Exception ex) {
                throw ex;
            }
        }
        return "redirect:/user/login";

    }

    @GetMapping("/form")
    public ModelAndView getForm() throws IOException {
        if(!_userTodoService.isLogged()) {
            response.sendRedirect("/user/login");
        }
        ModelAndView mv = new ModelAndView("form");
        return mv;
    }

    @PostMapping("/submitForm")
    public ModelAndView submitForm(@RequestParam String title, @RequestParam String description, @RequestParam("images") List<MultipartFile> images, HttpServletResponse response) throws IOException {
        if(!_userTodoService.isLogged()) {
            response.sendRedirect("/user/login");
        }
        ModelAndView mv = new ModelAndView("form");
        try {
            Todo todo = todoService.createTodo(title, description, images);
            response.sendRedirect("/todos-html");
        }catch (Exception ex) {
            mv.addObject("message", "error ajout");
        }

        return mv;
    }
}
