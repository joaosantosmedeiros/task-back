package com.drogas.TaskBack.controller;

import com.drogas.TaskBack.dto.request.TaskRequestDTO;
import com.drogas.TaskBack.model.Task;
import com.drogas.TaskBack.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity<Task> getOne(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(taskService.getById(id));
    }

    @GetMapping("/completed")
    public ResponseEntity<List<Task>> getCompleted() {
        return ResponseEntity.ok(taskService.getAllCompleted());
    }

    @GetMapping("/incompleted")
    public ResponseEntity<List<Task>> getIncompleted() {
        return ResponseEntity.ok(taskService.getAllIncompleted());
    }

    @GetMapping
    public ResponseEntity<List<Task>> list() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody @Valid TaskRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@RequestBody @Valid TaskRequestDTO dto, @PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(taskService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        taskService.delete(id);
    }
}
