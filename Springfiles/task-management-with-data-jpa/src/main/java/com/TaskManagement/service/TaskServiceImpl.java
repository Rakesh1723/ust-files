package com.TaskManagement.service;

import com.TaskManagement.dto.TaskDto;
import com.TaskManagement.exception.InvalidInputDataException;
import com.TaskManagement.exception.TaskNotFoundException;
import com.TaskManagement.model.State;
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
        if(task.name()==null || task.description()==null ||task.dueDate()==null||task.status()==null)
            throw new InvalidInputDataException("Please enter valid data");

        Task obj = EntityDtoUtil.covertToEntity(task);
        Task savedTask = taskRepoImpl.save(obj);
        return EntityDtoUtil.covertToDto(savedTask);
    }
    @Override
    public TaskDto getTask(int id) {
        return taskRepoImpl.findById(id).map(EntityDtoUtil::covertToDto).orElseThrow(()-> new TaskNotFoundException("Task with id "+id+" not found"));
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return taskRepoImpl.findAll().stream().map(EntityDtoUtil::covertToDto).toList();
    }

    @Override
    public void deleteTask(int id) {
          //  taskRepoImpl.deleteById(id);
          Task exTask=taskRepoImpl.findById(id).orElseThrow(()-> new TaskNotFoundException("Task with id "+id+" not found"));
            if(exTask != null) {
                exTask.setState(State.INACTIVE);
                taskRepoImpl.save(exTask);
            }
    }

    @Override
    public TaskDto updateTask(int id, TaskDto task) {

        if(task.name()==null || task.description()==null ||task.dueDate()==null||task.status()==null)
            throw new InvalidInputDataException("Please enter valid data");

        Task obj = EntityDtoUtil.covertToEntity(task);
        Task exTask=taskRepoImpl.findById(id).orElse(null);
        if(exTask!=null) {
            exTask.setName(obj.getName());
            exTask.setDescription(obj.getDescription());
            exTask.setDueDate(obj.getDueDate());
            exTask.setStatus(obj.getStatus());
            return EntityDtoUtil.covertToDto(taskRepoImpl.save(exTask));
        }
        throw new InvalidInputDataException("Task with id "+id+" not found to update");
    }
}
