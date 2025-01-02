package traineeapp.service;

import traineeapp.model.Trainee;

import java.util.List;

public interface TraineeService {

    public Trainee saveTrainee(Trainee trainee);

    public Trainee getTrainee(int id);

    public List<Trainee> getAllTrainees();

    public void deleteTrainee(int id);

}
