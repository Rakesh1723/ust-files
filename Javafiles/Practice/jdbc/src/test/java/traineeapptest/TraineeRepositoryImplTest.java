package traineeapptest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import traineeapp.model.Trainee;
import traineeapp.repository.TraineeRepository;
import traineeapp.repository.TraineeRepositoryImpl;
import traineeapp.service.TraineeServiceImpl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TraineeRepositoryImplTest {

    @Mock
    TraineeRepositoryImpl traineeRepository;

    @InjectMocks
    TraineeRepositoryImpl traineeRepositoryImpl;

    @Test
    void testSave() throws RuntimeException, SQLException {

        Trainee trainee = new Trainee(1,"sairam","hyderabad", LocalDate.of(2024,9,11));
        Mockito.when(traineeRepositoryImpl.save(trainee)).thenReturn(trainee);

        Assertions.assertDoesNotThrow(()->traineeRepositoryImpl.save(trainee));

    }

//    @Mock
//    TraineeRepositoryImpl traineeRepository;
//
//    @InjectMocks
//    TraineeServiceImpl traineeService;
//
//    @Test
//   public  void testSave()  {
//
//        Trainee trainee = new Trainee(1,"sairam","hyderabad", LocalDate.of(2024,9,11));
//        Mockito.when(traineeRepository.save(trainee)).thenReturn(trainee);
//        traineeService.saveTrainee(trainee);
//        Assertions.assertEquals(trainee,traineeService.saveTrainee(trainee));
//        Assertions.assertDoesNotThrow(()->traineeService.saveTrainee(trainee));
//        Mockito.verify(traineeRepository,Mockito.times(3)).save(trainee);
//    }
//
//    @Test
//    public void testGetTrainee(){
//        Trainee trainee = new Trainee(1,"sairam","hyderabad", LocalDate.of(2024,9,11));
//        Mockito.when(traineeRepository.getTrainee(1)).thenReturn(trainee);
//        Assertions.assertEquals(trainee,traineeService.getTrainee(1));
//        Mockito.verify(traineeRepository,Mockito.times(1)).getTrainee(1);
//    }
//
//    @Test
//    public void testGetAllTrainees(){
//        Trainee trainee = new Trainee(1,"sairam","hyderabad", LocalDate.of(2024,9,11));
//        List<Trainee> al=new ArrayList<>();
//        al.add(trainee);
//        Mockito.when(traineeRepository.getAllTrainees()).thenReturn(al);
//        Assertions.assertEquals(al.size(),traineeService.getAllTrainees().size());
//        Mockito.verify(traineeRepository,Mockito.times(1)).getAllTrainees();
//
//    }
//
//    @Test
//    public void testDeletetrainee(){
//        Trainee trainee = new Trainee(1,"sairam","hyderabad", LocalDate.of(2024,9,11));
//        Mockito.doNothing().when(traineeRepository).deleteTrainee(1);
//        Assertions.assertDoesNotThrow(()->traineeService.deleteTrainee(1));
//        Mockito.verify(traineeRepository,Mockito.times(1)).deleteTrainee(1);
//    }



}


