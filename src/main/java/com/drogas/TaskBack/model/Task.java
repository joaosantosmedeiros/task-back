package com.drogas.TaskBack.model;

import com.drogas.TaskBack.dto.request.TaskRequestDTO;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity(name = "TASKS")
@Table(name = "TASKS")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean isCompleted;

    public Task() {}

    public Task(Long id) {
        this.id = id;
    }

    public Task(TaskRequestDTO taskRequestDTO) {
        this.description = taskRequestDTO.description();
        this.isCompleted = taskRequestDTO.isCompleted();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }
}
