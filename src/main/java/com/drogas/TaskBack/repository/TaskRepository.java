package com.drogas.TaskBack.repository;

import com.drogas.TaskBack.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByCompletedTrue();
    List<Task> findByCompletedFalse();
}
