package com.example.correctiontodolist.service;

import com.example.correctiontodolist.entity.Todo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UrgentTodoService {


    private HttpSession _httpSession;

    @Autowired
    private TodoService _todoService;

    private Set<Integer> urgentTodoIds;

    public UrgentTodoService(HttpSession httpSession) {
        _httpSession = httpSession;
        try {
            urgentTodoIds = (Set<Integer>) _httpSession.getAttribute("urgents");
        }catch (Exception ex) {
            urgentTodoIds = new HashSet<>();
        }
    }

    public boolean addToUrgent(int id) {
        Todo todo = _todoService.getTodoById(id);
        if(todo != null && !isUrgent(todo.getId())) {
            urgentTodoIds.add(todo.getId());
            _httpSession.setAttribute("urgents", urgentTodoIds);
            return true;
        }
        return false;
    }

    public boolean removeFromUrgent(int id) {
        if(isUrgent(id)) {
            return urgentTodoIds.remove(id);
        }
        return false;
    }

    public boolean isUrgent(int id) {
        return urgentTodoIds.contains(id);
    }

    public List<Todo> getUrgentsTodo() {
        if(urgentTodoIds.size() > 0) {
            List<Todo> todos = new ArrayList<>();
            for (int id : urgentTodoIds) {
                todos.add(_todoService.getTodoById(id));
            }
            return todos;
        }
        return null;
    }
}
