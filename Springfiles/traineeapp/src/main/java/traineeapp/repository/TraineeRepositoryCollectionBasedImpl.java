package traineeapp.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import traineeapp.model.Trainee;

import java.util.ArrayList;
import java.util.List;

@Repository
//@Primary
public class TraineeRepositoryCollectionBasedImpl implements TraineeRepository{

     List<Trainee> al=new ArrayList<>();

    @Override
    public Trainee save(Trainee trainee) {
        al.add(trainee);
        return trainee;
    }

    @Override
    public Trainee getTrainee(int id) {
        return null;
    }

    @Override
    public List<Trainee> getAllTrainees() {
        return al;
    }

    @Override
    public void deleteTrainee(int id) {

    }
}
