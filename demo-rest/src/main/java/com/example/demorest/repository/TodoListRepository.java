package com.example.demorest.repository;

import com.example.demorest.entity.TodoList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends CrudRepository<TodoList, Integer> {


}
