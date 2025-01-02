package traineeapp.service;

import traineeapp.model.Trainee;
import traineeapp.repository.TraineeRepository;
import traineeapp.repository.TraineeRepositoryImpl;

import java.util.List;

public class TraineeServiceImpl implements TraineeService{

   TraineeRepository traineeRepositoryImpl =new TraineeRepositoryImpl();

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
