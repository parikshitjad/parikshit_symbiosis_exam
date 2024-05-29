package com.task.TaskManager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.TaskManager.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

