package traineeapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traineeapp.model.Trainee;
import traineeapp.repository.TraineeRepository;
import traineeapp.repository.TraineeRepositoryImpl;

import java.util.List;

@Service
public class TraineeServiceImpl implements TraineeService{

    @Autowired
    TraineeRepository traineeRepositoryImpl;


    @Override
    public Trainee saveTrainee(Trainee trainee) {
        return traineeRepositoryImpl.save(trainee) ;
    }

    @Override
    public Trainee getTrainee(int id) {
        return traineeRepositoryImpl.getTrainee(id);
    }

    @Override
    public List<Trainee> getAllTrainees() {
        return traineeRepositoryImpl.getAllTrainees();
    }

    @Override
    public void deleteTrainee(int id) {
        traineeRepositoryImpl.deleteTrainee(id);
    }
}
