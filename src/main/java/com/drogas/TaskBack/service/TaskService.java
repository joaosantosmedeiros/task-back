package com.drogas.TaskBack.service;

import com.drogas.TaskBack.dto.request.TaskRequestDTO;
import com.drogas.TaskBack.model.Task;
import com.drogas.TaskBack.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task getById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Task"));
    }

    public Task save(TaskRequestDTO taskRequestDTO){
        Task task = new Task(taskRequestDTO);
        return taskRepository.save(task);
    }

    public Task update(Long taskId, TaskRequestDTO taskRequestDTO) {
        Task task = getById(taskId);
        task.setDescription(taskRequestDTO.description());
        task.setCompleted(taskRequestDTO.completed());

        return taskRepository.save(task);
    }

    public void delete(Long id) {
        var task = getById(id);
        taskRepository.delete(task);
    }
}
