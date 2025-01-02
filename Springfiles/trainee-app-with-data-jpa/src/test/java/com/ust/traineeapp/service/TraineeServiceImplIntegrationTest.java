package com.ust.traineeapp.service;

import com.ust.traineeapp.exception.RecordNotFoundException;
import com.ust.traineeapp.model.Project;
import com.ust.traineeapp.model.Trainee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static com.ust.traineeapp.model.Status.ONGOING;

@SpringBootTest  // for integration testing
class TraineeServiceImplIntegrationTest {

    @Autowired
    TraineeServiceImpl traineeService;

    @Test
    void saveTrainee() {
        Trainee t=new Trainee(4, "Umesh", "Gurgaon", LocalDate.now(),null);
        Assertions.assertEquals(t,traineeService.saveTrainee(t));
        Assertions.assertDoesNotThrow(()->traineeService.getTraineeById(t.getId()));
    }

    @Test
    void getTraineeById() {
        var id = 1;
        Assertions.assertDoesNotThrow(()->traineeService.getTraineeById(id));
       // Assertions.assertDoesNotThrow(()->traineeService.getTraineeById(4));
        Assertions.assertThrows(RecordNotFoundException.class,()->traineeService.getTraineeById(100));

    }
}