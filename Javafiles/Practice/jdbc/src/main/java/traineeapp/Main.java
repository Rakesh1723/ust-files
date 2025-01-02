package traineeapp;


import traineeapp.model.Trainee;
import traineeapp.repository.TraineeRepository;
import traineeapp.repository.TraineeRepositoryImpl;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        TraineeRepository repository = new TraineeRepositoryImpl();

        //  Trainee trainee = new Trainee(2,"amaan","hyderabad", LocalDate.of(2024,9,11));
        
       //   repository.save(trainee);

          repository.getAllTrainees().forEach(i->System.out.println(i));
        //  repository.deleteTrainee(2);

    }
}