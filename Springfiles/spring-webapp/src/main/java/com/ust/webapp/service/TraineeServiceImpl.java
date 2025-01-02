package com.ust.webapp.service;

import com.ust.webapp.dto.TraineeDto;
import com.ust.webapp.model.Trainee;
import com.ust.webapp.repository.TraineeRepo;
import com.ust.webapp.util.EntityDtoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraineeServiceImpl implements TraineeService{

    @Autowired
    TraineeRepo traineeRepoImpl;

    @Override
    public TraineeDto addTrainee(TraineeDto trainee) {
        Trainee obj = EntityDtoUtil.covertToEntity(trainee);
        Trainee savedTrainee = traineeRepoImpl.addTrainee(obj);
        return EntityDtoUtil.covertToDto(savedTrainee);
    }


    @Override
    public TraineeDto getTrainee(int id) {
        return traineeRepoImpl.getTrainee(id).map(EntityDtoUtil::covertToDto).orElse(null);
    }

    @Override
    public List<TraineeDto> getAllTrainees() {
       return traineeRepoImpl.getAllTrainees().stream().map(EntityDtoUtil::covertToDto).toList();
    }

    @Override
    public void deleteTrainee(int id) {
         traineeRepoImpl.deleteTrainee(id);
    }

    @Override
    public TraineeDto updateTrainee(int id,TraineeDto trainee) {
        Trainee obj = EntityDtoUtil.covertToEntity(trainee);
        Trainee updatedTrainee = traineeRepoImpl.updateTrainee(id,obj);
        return EntityDtoUtil.covertToDto(updatedTrainee);

    }
}
