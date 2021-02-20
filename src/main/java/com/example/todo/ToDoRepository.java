package com.example.todo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ToDoRepository extends MongoRepository<ToDo, String>{
    public List<ToDo> findByName(String name);
    public List<ToDo> findByCompleted(Boolean completed);
}
