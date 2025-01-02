package com.TaskManagement.controller;


import com.TaskManagement.dto.TaskDto;
import com.TaskManagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/add-task")
    public String addTask(@ModelAttribute("task") TaskDto task){
          taskService.addTask(task);
          return "index.jsp";
    }

    @GetMapping("/get-task")
    public String getTaskById(Model m,@RequestParam("id") int id){
        List<TaskDto> al=new ArrayList<>();
        al.add(taskService.getTask(id));
        m.addAttribute("tasks",al);
        return "view.jsp";
    }

    @GetMapping("/view-task")
    public String getAllTasks(Model m){
        List<TaskDto> al=  taskService.getAllTasks();
        System.out.println(al);
        m.addAttribute("tasks",al);
        return "view.jsp";
    }

    @PostMapping("/delete-task")
    public String deleteTask(Model m, @RequestParam("id") int id){
        taskService.deleteTask(id);
        m.addAttribute("tasks", taskService.getAllTasks());
        return  "view.jsp";
    }


    @PostMapping("/update-task")
    public String updateTask(Model m, @RequestParam("id") int id,@ModelAttribute("task") TaskDto task) {
        taskService.updateTask(id,task);
        m.addAttribute("tasks", taskService.getAllTasks());
        return  "update.jsp";
    }

}
