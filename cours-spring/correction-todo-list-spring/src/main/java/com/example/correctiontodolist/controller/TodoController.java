package com.example.correctiontodolist.controller;

import com.example.correctiontodolist.entity.Todo;
import com.example.correctiontodolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todo")
@ResponseBody
public class TodoController {

    @Autowired
    private TodoService _todoService;

    @PostMapping("")
    public Todo post(@RequestParam String title, @RequestParam String description) throws Exception {
        try {
            Todo todo = _todoService.createTodo(title, description);
            return todo;
        }catch (Exception ex) {
            throw ex;
        }
    }

    @PostMapping("/update")
    public Todo post(@RequestParam Integer id, @RequestParam String title, @RequestParam String description) throws Exception {
        try {
            Todo todo = _todoService.updateTodo(id,title, description);
            return todo;
        }catch (Exception ex) {
            throw ex;
        }
    }

    @GetMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id) throws Exception {
        try {
            return _todoService.deleteTodo(id);
        }catch (Exception ex) {
            throw ex;
        }
    }

    @GetMapping("/update/{id}")
    public boolean updateStatus(@PathVariable Integer id) throws Exception {
        try {
            return _todoService.updateStatus(id);
        }catch (Exception ex) {
            throw ex;
        }
    }
    @GetMapping("{status}")
    public List<Todo> get(@PathVariable boolean status) {
        return _todoService.getByStatus(status);
    }
}
