package com.example.correctiontodolist.repository;

import com.example.correctiontodolist.entity.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Annotation pour déclarer un spring beans en tant que repository comme service ou controller
@Repository
public interface TodoRespository extends CrudRepository<Todo, Integer> {
    public List<Todo> findByStatus(boolean status);
}
