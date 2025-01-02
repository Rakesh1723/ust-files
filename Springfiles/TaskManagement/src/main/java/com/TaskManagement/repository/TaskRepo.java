package com.TaskManagement.repository;

import com.TaskManagement.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepo {
    public Task addTask(Task task);

    public Optional<Task> getTask(int id);

    public List<Task> getAllTasks();

    public void deleteTask(int id);

    Task updateTask(int id, Task task);
}
