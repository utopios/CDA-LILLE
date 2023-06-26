package com.example.correctiontodolist.service;

import com.example.correctiontodolist.entity.Image;
import com.example.correctiontodolist.entity.Todo;
import com.example.correctiontodolist.repository.impl.ImageRepository;
import com.example.correctiontodolist.repository.impl.TodoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRespository _todoRespository;

    @Autowired
    private ImageRepository _imageRepository;

    @Autowired
    private UploadService uploadService;

    public Todo createTodo(String title, String description) throws Exception {
        if(title == null || description == null) {
            throw new Exception("Remplir la totalité des champs");
        }
        Todo todo = new Todo(title, description);
        if(_todoRespository.create(todo)) {
            return todo;
        }
        return null;
    }

    public Todo createTodo(String title, String description, List<MultipartFile> images) throws Exception {
        if(title == null || description == null) {
            throw new Exception("Remplir la totalité des champs");
        }
        Todo todo = new Todo(title, description);

        if(_todoRespository.create(todo)) {
            for(MultipartFile img : images) {
                Image image =new Image();
                image.setUrl(uploadService.store(img));
                image.setTodo(todo);
                _imageRepository.create(image);
                //todo.getImages().add(image);
            }
            return todo;
        }
        return null;
    }

    public Todo updateTodo(int id, String title, String description) throws Exception {
        Todo todo = _todoRespository.findById(id);
        if(todo != null) {
            todo.setTitle(title);
            todo.setDescription(description);
            _todoRespository.update(todo);
            return todo;
        }
        throw new Exception("Aucun todo avec cet id");
    }

    public boolean deleteTodo(int id) throws Exception {
        Todo todo = _todoRespository.findById(id);
        if(todo != null) {
            _todoRespository.delete(todo);
            return true;
        }
        throw new Exception("Aucun todo avec cet id");
    }

    public boolean updateStatus(int id) throws Exception {
        Todo todo = _todoRespository.findById(id);
        if(todo != null) {
            todo.setStatus(!todo.isStatus());
            _todoRespository.update(todo);
            return true;
        }
        throw new Exception("Aucun todo avec cet id");
    }

    public List<Todo> getByStatus(boolean status) {
        return _todoRespository.findByStatus(status);
    }

    public Todo getTodoById(int id) {
        return _todoRespository.findById(id);
    }
}
