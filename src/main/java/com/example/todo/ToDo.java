package com.example.todo;

import org.springframework.data.annotation.Id;


public class ToDo {

    @Id
    private String id;

    private String name;
    private String description;
    private Boolean completed;
    private String notes;

    ToDo(String id, String name, String description, Boolean completed, String notes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.completed = completed;
        this.notes = notes;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Boolean getCompleted() {
        return this.completed;
    }

    public String getNotes() {
        return this.notes;
    }

    public String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format(
                "ToDo[id=%s, name='%s', description='%s', completed='%b', notes='%s']",
                id, name, description, completed, notes);
    }

}