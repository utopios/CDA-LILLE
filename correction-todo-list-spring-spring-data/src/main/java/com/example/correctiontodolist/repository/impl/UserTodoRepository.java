package com.example.correctiontodolist.repository.impl;


import com.example.correctiontodolist.entity.UserTodo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTodoRepository extends CrudRepository<UserTodo, Integer> {
    public UserTodo findByEmail(String email);
}
