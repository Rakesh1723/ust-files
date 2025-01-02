package com.ust.traineeapp.repository;

import com.ust.traineeapp.model.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraineeRepository extends JpaRepository<Trainee,Integer> {
    Trainee findByName(String name);
}
