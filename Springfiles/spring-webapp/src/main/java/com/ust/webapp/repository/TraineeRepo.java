package com.ust.webapp.repository;

import com.ust.webapp.model.Trainee;

import java.util.List;
import java.util.Optional;

public interface TraineeRepo {

    public Trainee addTrainee(Trainee trainee);

    public Optional<Trainee> getTrainee(int id);

    public List<Trainee> getAllTrainees();

    public void deleteTrainee(int id);

    Trainee updateTrainee(int id, Trainee trainee);
}
