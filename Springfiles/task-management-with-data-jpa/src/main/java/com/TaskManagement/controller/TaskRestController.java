package com.TaskManagement.controller;

import com.TaskManagement.dto.TaskDto;
import com.TaskManagement.exception.InvalidInputDataException;
import com.TaskManagement.exception.TaskNotFoundException;
import com.TaskManagement.model.Status;
import com.TaskManagement.repository.TaskRepo;
import com.TaskManagement.service.TaskService;
import com.TaskManagement.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = {"http://127.0.0.1:5500"})
@RestController
@RequestMapping("/api/v3/tasks")
public class TaskRestController {

    @Autowired
    private TaskService taskService;

    @Autowired
    TaskRepo taskRepoImpl;

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
    public TaskDto saveTask(@RequestBody TaskDto task){
        TaskDto savedTask = taskService.addTask(task);
        return savedTask;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable("id") int id){
        taskService.deleteTask(id);
    }

    @GetMapping("/name")
    @ResponseStatus(code = HttpStatus.OK)
    public TaskDto getTaskByName(@RequestParam("name") String name){
       // return taskService.getAllTasks().stream().filter(i->i.name().equalsIgnoreCase(name)).findFirst().get();
         return EntityDtoUtil.covertToDto(taskRepoImpl.findByNameIgnoreCase(name).orElseThrow(()-> new TaskNotFoundException("Task with name  "+name+" not found")));
    }

    @PutMapping("/{id}")
    @ResponseStatus(code=HttpStatus.ACCEPTED)
    public TaskDto updateTask(@PathVariable("id") Integer id,@RequestBody TaskDto task)
    {   if( id == null ){
           throw new InvalidInputDataException("Please enter valid data");
        }
        return taskService.updateTask(id,task);
    }

    @GetMapping("/status")
    public List<TaskDto> getAllTasksByStatus(@RequestParam("status") Status status){
//        if(status==Status.COMPLETED)
//           return taskService.getAllTasks().stream().filter(i->i.status()==Status.COMPLETED).toList();
//        else
//           return taskService.getAllTasks().stream().filter(i->i.status()==Status.PENDING).toList();
          return taskRepoImpl.findByStatus(status).stream().map(EntityDtoUtil::covertToDto).toList();
    }

    @GetMapping("/overdue")
    public List<TaskDto> getAllOverdueTasks(){
     //   return taskService.getAllTasks().stream().filter(i->i.dueDate().isBefore(LocalDate.now()) && i.status()==Status.PENDING).toList();
         return taskRepoImpl.getAllOverdueTasks().stream().map(EntityDtoUtil::covertToDto).toList();
    }

    @GetMapping("/sort")
    public List<TaskDto> getAllTasksSortedByDueDate(){
      //  return taskService.getAllTasks().stream().sorted(Comparator.comparing(TaskDto::dueDate)).toList();
         return taskRepoImpl.getAllTasksSortedByDueDate().stream().map(EntityDtoUtil::covertToDto).toList();
    }

    @GetMapping("/deletedTasks")
    public List<TaskDto> getAllDeletedTask(){
         return taskRepoImpl.getAllDeletedTasks().stream().map(EntityDtoUtil::covertToDto).toList();
    }

    @Transactional
    @PutMapping("/retrieveDeletedTask/{id}")
    public TaskDto retrieveDeletedTask(@PathVariable("id") int id){
           taskRepoImpl.retrieveDeletedTask(id);
           return taskService.getTask(id);
    }

}

