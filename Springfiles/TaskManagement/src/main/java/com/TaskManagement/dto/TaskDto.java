package com.TaskManagement.dto;

import java.time.LocalDate;

public record TaskDto(int id, String name, String description, LocalDate dueDate,boolean completed){
}
