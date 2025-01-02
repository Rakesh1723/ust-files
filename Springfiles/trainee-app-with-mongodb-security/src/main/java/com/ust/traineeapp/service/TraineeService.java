package com.ust.traineeapp.service;

import com.ust.traineeapp.model.Trainee;

import java.math.BigInteger;
import java.util.List;

public interface TraineeService {

    Trainee saveTrainee(Trainee trainee);
    Trainee findTraineeById(BigInteger id);
    List<Trainee> getAllTrainees();
    void removeTrainee(BigInteger id);
    Trainee updateTrainee(BigInteger id,Trainee trainee);
}
