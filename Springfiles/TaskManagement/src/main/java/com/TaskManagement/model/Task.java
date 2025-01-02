package com.TaskManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private int id;
    private String name;
    private String description;
    private LocalDate dueDate;
    private boolean completed;
}
