package com.example.demorest.controller;

import com.example.demorest.entity.TodoList;
import com.example.demorest.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todolists")
public class TodoListController {

    @Autowired
    private TodoListRepository _todoListRepository;

    @PostMapping("")
    public ResponseEntity<TodoList> post(@RequestBody TodoList todoList) {
        TodoList response = _todoListRepository.save(todoList);
        if(response != null) {
            return ResponseEntity.ok(response);
        }
        else {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("")
    public ResponseEntity<List<TodoList>> get() {
        return ResponseEntity.ok((List<TodoList>) _todoListRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoList> get(@PathVariable int id) {
        TodoList response = _todoListRepository.findById(id).get();
        if(response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }
}
