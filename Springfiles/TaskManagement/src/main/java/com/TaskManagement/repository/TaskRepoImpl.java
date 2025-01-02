package com.TaskManagement.repository;

import com.TaskManagement.model.Task;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepoImpl  implements TaskRepo{

    List<Task> al;

    @PostConstruct
    void init(){
        al=new ArrayList<>();
        Task t1=new Task(1,"Complete Assignment","Finish the HTML, CSS, Bootstrap, and JS task",LocalDate.of(2024,9,28),false);
        Task t2=new Task(2,"Play Cricket","Reach the turf on time tonight to play cricket",LocalDate.of(2024,9,29),true);
        al.add(t1);
        al.add(t2);
    }

    @Override
    public Task addTask(Task task) {
        al.add(task);
        return task;
    }

    @Override
    public Optional<Task> getTask(int id) {
        return al.stream().filter(i->i.getId() == id).findFirst();
    }

    @Override
    public List<Task> getAllTasks() {
        return al;
    }

    @Override
    public void deleteTask(int id) {
        al.removeIf(i->i.getId()==id);
    }

    @Override
    public Task updateTask(int id, Task task) {
        Task savedTask = getTask(id).orElseThrow();
        savedTask.setName(task.getName());
        savedTask.setDescription(task.getDescription());
        savedTask.setDueDate(task.getDueDate());
        savedTask.setCompleted(task.isCompleted());
        return savedTask;
    }
}
