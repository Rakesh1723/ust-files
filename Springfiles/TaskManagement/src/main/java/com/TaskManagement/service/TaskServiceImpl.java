package com.TaskManagement.service;

import com.TaskManagement.dto.TaskDto;
import com.TaskManagement.model.Task;
import com.TaskManagement.repository.TaskRepo;
import com.TaskManagement.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    TaskRepo taskRepoImpl;

    @Override
    public TaskDto addTask(TaskDto task) {
        Task obj = EntityDtoUtil.covertToEntity(task);
        Task savedTask = taskRepoImpl.addTask(obj);
        return EntityDtoUtil.covertToDto(savedTask);
    }
    @Override
    public TaskDto getTask(int id) {
        return taskRepoImpl.getTask(id).map(EntityDtoUtil::covertToDto).orElse(null);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return taskRepoImpl.getAllTasks().stream().map(EntityDtoUtil::covertToDto).toList();

    }

    @Override
    public void deleteTask(int id) {
        taskRepoImpl.deleteTask(id);
    }

    @Override
    public TaskDto updateTask(int id, TaskDto task) {
        Task obj = EntityDtoUtil.covertToEntity(task);
        Task updatedTask = taskRepoImpl.updateTask(id,obj);
        return EntityDtoUtil.covertToDto(updatedTask);
    }
}
