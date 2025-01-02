package com.TaskManagement.controller;

import com.TaskManagement.dto.TaskDto;
import com.TaskManagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@CrossOrigin(origins = {"http://127.0.0.1:5500"})
@RestController
@RequestMapping("/api/v1/tasks")
public class TaskRestController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTask(@PathVariable("id") int id){
        if(taskService.getTask(id) != null)
            return ResponseEntity.status(HttpStatus.OK).body(taskService.getTask(id));
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<TaskDto> getAllTask(){
        return taskService.getAllTasks();
    }

    @PostMapping
    public ResponseEntity<TaskDto> saveTask(@RequestBody TaskDto task){
        TaskDto savedTask = taskService.addTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable("id") int id){
        taskService.deleteTask(id);
    }

    @GetMapping("/name")
    @ResponseStatus(code = HttpStatus.OK)
    public TaskDto getTaskByName(@RequestParam("name") String name){
        return taskService.getAllTasks().stream().filter(i->i.name().equalsIgnoreCase(name)).findFirst().get();
    }


    @PutMapping("/{id}")
    @ResponseStatus(code=HttpStatus.ACCEPTED)
    public TaskDto updateTask(@PathVariable("id") int id,@RequestBody TaskDto task)
    {
        return taskService.updateTask(id,task);
    }

}

