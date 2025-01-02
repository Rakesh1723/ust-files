package com.ust.webapp.service;

import com.ust.webapp.dto.TraineeDto;

import java.util.List;

public interface TraineeService {

    public TraineeDto addTrainee(TraineeDto trainee);

    public TraineeDto getTrainee(int id);

    public List<TraineeDto> getAllTrainees();

    public void deleteTrainee(int id);

    public TraineeDto updateTrainee(int id,TraineeDto trainee);
}
