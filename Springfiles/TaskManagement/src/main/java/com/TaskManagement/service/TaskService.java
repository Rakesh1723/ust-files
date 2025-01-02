package com.TaskManagement.service;

import com.TaskManagement.dto.TaskDto;

import java.util.List;

public interface TaskService {
    public TaskDto addTask(TaskDto task);

    public TaskDto getTask(int id);

    public List<TaskDto> getAllTasks();

    public void deleteTask(int id);

    public TaskDto updateTask(int id,TaskDto Task);
}

