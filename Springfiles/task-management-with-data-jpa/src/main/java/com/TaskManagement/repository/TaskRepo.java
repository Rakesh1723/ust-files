package com.TaskManagement.repository;

import com.TaskManagement.dto.TaskDto;
import com.TaskManagement.model.Status;
import com.TaskManagement.model.Task;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface TaskRepo extends JpaRepository<Task,Integer> {


    Optional<Task> findByNameIgnoreCase(String name);

    List<Task> findByStatus(Status status);

    @Query("from Task where dueDate < Current_Date and status=PENDING")
    List<Task> getAllOverdueTasks();

    @Query("from Task order by dueDate")
    List<Task> getAllTasksSortedByDueDate();

    @Query("from Task where state=INACTIVE")
    List<Task> getAllDeletedTasks();

    @Query("from Task where state=ACTIVE")
    List<Task> findAll();

    @Query("from Task where state=ACTIVE and id=:id")
    Optional<Task> findById(int id);

    @Modifying
    @Query("update Task set state=ACTIVE where id=:id")
    void retrieveDeletedTask(int id);

}
