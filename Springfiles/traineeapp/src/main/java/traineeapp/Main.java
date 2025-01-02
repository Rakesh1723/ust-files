package traineeapp;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import traineeapp.configuration.TraineeAppConfig;
import traineeapp.model.Trainee;
import traineeapp.repository.TraineeRepository;
import traineeapp.repository.TraineeRepositoryImpl;
import traineeapp.service.TraineeService;
import traineeapp.service.TraineeServiceImpl;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

         ApplicationContext context=new AnnotationConfigApplicationContext(TraineeAppConfig.class);
         TraineeService service=context.getBean(TraineeServiceImpl.class);
         service.getAllTrainees().forEach(i->System.out.println(i));


    }
}