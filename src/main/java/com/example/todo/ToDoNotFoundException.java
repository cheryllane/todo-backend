package com.example.todo;

public class ToDoNotFoundException extends RuntimeException {
    ToDoNotFoundException(String id) {
        super("Could not find a to do with id " + id);
    }
}
