package com.example.demorest.controller;

import com.example.demorest.entity.TodoItem;
import com.example.demorest.entity.TodoList;
import com.example.demorest.repository.TodoItemRepository;
import com.example.demorest.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todolists/{id}")
public class TodoItemController {

    @Autowired
    private TodoItemRepository _todoItemRepository;

    @Autowired
    private TodoListRepository _todoListRepository;

    @GetMapping("todoitems")
    public ResponseEntity<List<TodoItem>> get(@PathVariable int id){
        List<TodoItem> response = _todoItemRepository.findAllByTodoListId(id);
        if(response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("todoitems/{todoitem_id}")
    public ResponseEntity<TodoItem> get(@PathVariable int id, @PathVariable int todoitem_id){
        TodoItem response = _todoItemRepository.findById(todoitem_id).get();
        if(response == null) {
            return ResponseEntity.notFound().build();
        }
        if(response.getTodoList().getId() != id) {
            return  ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/todoitems")
    public ResponseEntity<TodoItem> post(@PathVariable int id, @RequestBody TodoItem todoItem) {
        TodoList todoList = _todoListRepository.findById(id).get();
        if(todoList == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            todoList.getTodoItems().add(todoItem);
            todoItem.setTodoList(todoList);
            TodoItem response = _todoItemRepository.save(todoItem);
            return ResponseEntity.ok(response);
        }

    }
}


