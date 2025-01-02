package com.ust.traineeapp.service;

import com.ust.traineeapp.model.Project;
import com.ust.traineeapp.model.Trainee;

import java.util.List;

public interface TraineeService {
    Trainee saveTrainee(Trainee trainee);
    Trainee getTraineeById(int id);
    void deleteTrainee(int id);
    List<Trainee> getAllTrainee();
    Trainee updateTrainee(int id,Trainee trainee);
    Trainee findTraineeByName(String name);
    List<Trainee>  findTraineeByLocation(String location);

    Project saveProject(Project project);
    Trainee updateTraineeWithProject(int tid,int pid);

    List<Trainee> findTraineeByMonthAndYear(int month,int year);
}
