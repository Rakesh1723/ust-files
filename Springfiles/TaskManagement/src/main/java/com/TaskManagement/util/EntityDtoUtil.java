package com.TaskManagement.util;


import com.TaskManagement.dto.TaskDto;
import com.TaskManagement.model.Task;

public class EntityDtoUtil {
    public static TaskDto covertToDto(Task task){
        TaskDto taskDto = new TaskDto(
                task.getId(),
                task.getName(),
                task.getDescription(),
                task.getDueDate(),
                task.isCompleted()
        );
        return taskDto;
    }

    public static Task covertToEntity(TaskDto taskDto){
        Task task = new Task(
                taskDto.id(),
                taskDto.name(),
                taskDto.description(),
                taskDto.dueDate(),
                taskDto.completed()
        );
        return task;
    }

}