package com.TaskManagement.dto;

import com.TaskManagement.model.Status;

import java.time.LocalDate;

public record TaskDto(int id, String name, String description, LocalDate dueDate, Status status){
}
