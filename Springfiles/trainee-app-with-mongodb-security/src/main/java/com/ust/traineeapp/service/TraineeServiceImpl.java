package com.ust.traineeapp.service;

import com.ust.traineeapp.model.Trainee;
import com.ust.traineeapp.repository.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class TraineeServiceImpl implements TraineeService{

    @Autowired
    private TraineeRepository traineeRepo;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public Trainee saveTrainee(Trainee trainee) {
       if(trainee.getId()!=null && traineeRepo.existsById(trainee.getId()))
       {
           throw new RuntimeException("Trainee with ID : "+trainee.getId()+"not found");
       }
       return traineeRepo.save(trainee);
    }

    @Override
    public Trainee findTraineeById(BigInteger id) {
        return traineeRepo.findById(id).orElse(null);
    }

    @Override
    @PreAuthorize("hasRole('USER')")
    public List<Trainee> getAllTrainees() {
        return traineeRepo.findAll();
    }

    @Override
    public void removeTrainee(BigInteger id) {
         traineeRepo.deleteById(id);
    }

    @Override
    public Trainee updateTrainee(BigInteger id, Trainee trainee) {
        if(traineeRepo.existsById(trainee.getId()))
        {  traineeRepo.save(trainee);

        }
        throw new RuntimeException("Trainee with ID : "+trainee.getId()+"not found");
    }
}
