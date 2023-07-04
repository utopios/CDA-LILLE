package com.example.demorest.repository;

import com.example.demorest.entity.TodoItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoItemRepository extends CrudRepository<TodoItem, Integer> {
    public List<TodoItem> findAllByTodoListId(int id);

    @Query("select TodoItem from TodoItem where taskName=:taskName")
    public List<TodoItem> findCustom(String taskName);
}
