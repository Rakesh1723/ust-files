package com.ust.traineeapp.service;

import com.ust.traineeapp.exception.RecordNotFoundException;
import com.ust.traineeapp.model.Trainee;
import com.ust.traineeapp.repository.TraineeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)  // for unit testing
public class TraineeServiceImplUnitTest {

    @Autowired
    @Mock
    TraineeRepository traineeRepository;

    @InjectMocks
    TraineeServiceImpl traineeService;

    @Test
    void saveTrainee() {

        Trainee trainee = new Trainee(1, "Umesh", "Gurgaon", LocalDate.now(),null);

        Mockito.when(traineeRepository.save(trainee)).thenReturn(trainee);

        Assertions.assertDoesNotThrow(() -> traineeService.saveTrainee(trainee));
        Assertions.assertEquals(trainee,traineeService.saveTrainee(trainee));

        Mockito.when(traineeRepository.findById(trainee.getId()))
                .thenReturn(Optional.of(trainee));
        Assertions.assertDoesNotThrow(()->traineeService.getTraineeById(trainee.getId()));

        Mockito.verify(traineeRepository,Mockito.times(2)).save(trainee);
        Mockito.verify(traineeRepository,Mockito.times(2)).existsById(trainee.getId());

    }

    @Test
    void getTraineeById() {
        // Given
        var id = 1;
        var invalidId = 100;
        Trainee trainee = new Trainee(1, "Umesh", "Gurgaon", LocalDate.now(),null);

        Mockito.when(traineeRepository.findById(id))
                .thenReturn(Optional.of(trainee));

        Mockito.when(traineeRepository.findById(invalidId))
                .thenThrow(new RecordNotFoundException(""));

        Assertions.assertDoesNotThrow(() -> traineeService.getTraineeById(id));

        Assertions.assertThrows(RecordNotFoundException.class, () -> traineeService.getTraineeById(100));
        Assertions.assertThrows(RecordNotFoundException.class, () -> traineeService.getTraineeById(invalidId));
    }

}
