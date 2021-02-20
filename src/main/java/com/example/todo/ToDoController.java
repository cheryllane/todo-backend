package com.example.todo;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

@RestController
public class ToDoController {
    private final ToDoRepository repository;

    ToDoController(ToDoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/todo")
    List<ToDo> all(@RequestParam Optional<String> search) {
        return repository.findAll();
    }

    @PostMapping("/todo")
    ToDo newToDo(@RequestBody ToDo newToDo) {
        return repository.save(newToDo);
    }

    @GetMapping("/todo/{id}")
    ToDo getSingle(@PathVariable String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ToDoNotFoundException(id));
    }

    @PutMapping("/todo/{id}")
    ToDo updateSingle(@RequestBody ToDo newToDo,@PathVariable String id) {
        return repository.findById(id)
                .map(toDo -> {
                    toDo.setName(newToDo.getName());
                    toDo.setDescription(newToDo.getDescription());
                    toDo.setCompleted(newToDo.getCompleted());
                    toDo.setNotes(newToDo.getNotes());
                    return repository.save(toDo);
                }).orElseGet(() -> repository.save(newToDo));
    }

    @DeleteMapping("/todo/{id}")
    void deleteToDo(@PathVariable String id) {
        repository.deleteById(id);
    }
}
