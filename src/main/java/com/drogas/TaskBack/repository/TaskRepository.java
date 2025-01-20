package com.drogas.TaskBack.repository;

import com.drogas.TaskBack.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
