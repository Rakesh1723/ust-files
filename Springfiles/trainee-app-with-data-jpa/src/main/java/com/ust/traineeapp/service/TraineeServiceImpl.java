package com.ust.traineeapp.service;

import com.ust.traineeapp.exception.EntityAlreadyExistException;
import com.ust.traineeapp.exception.RecordNotFoundException;
import com.ust.traineeapp.model.Project;
import com.ust.traineeapp.model.Trainee;
import com.ust.traineeapp.repository.ProjectRepository;
import com.ust.traineeapp.repository.TraineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TraineeServiceImpl implements TraineeService{

     @Autowired
    private TraineeRepository traineeRepo;

     @Autowired
     private ProjectRepository projectRepository;

    @Override
    public Trainee saveTrainee(Trainee trainee) {
        if(traineeRepo.existsById(trainee.getId())){
            throw new EntityAlreadyExistException("Trainee with id "+trainee.getId()+" already exists");
        }
      //  return traineeRepo.save(trainee);


//        manual mapping for oneToOne single side on trainee.
//        Project project=trainee.getProject();
//        projectRepository.save(project);
//        Trainee savedTrainee=traineeRepo.save(trainee);
//        savedTrainee.setProject(project);


// //        mapping both sides oneToOne
//        Trainee savedTrainee = traineeRepo.save(trainee);
//        Project project = savedTrainee.getProject();
//        project.setTrainee(savedTrainee);
//        projectRepository.save(project);
//        return savedTrainee;


//        one2many and many2one mapping
        Trainee savedTrainee = null;
        if(trainee.getProject()!=null) {
            Project project = projectRepository.findById(trainee.getProject().getId()).orElse(null);
            if (project != null) {
                trainee.setProject(project);
                savedTrainee = traineeRepo.save(trainee);
                project.getTrainees().add(savedTrainee);
                projectRepository.save(project);
            }
            else{
                savedTrainee = traineeRepo.save(trainee);
            }
        }
        else {
            savedTrainee = traineeRepo.save(trainee);
        }
        return savedTrainee;



//        Trainee savedTrainee= traineeRepo.save(trainee);
//        Project project=savedTrainee.getProject();
//        project.getTrainees().add(savedTrainee);
//        projectRepository.save(project);
//        return savedTrainee;


    }

    @Override
    public Trainee getTraineeById(int id) {
        return traineeRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Trainee with ID "+id+" Not found"));
    }

    @Override
    public void deleteTrainee(int id) {
         traineeRepo.deleteById(id);
    }

    @Override
    public List<Trainee> getAllTrainee() {
        return traineeRepo.findAll();
    }

    @Override
    public Trainee updateTrainee(int id,Trainee trainee) {
       // return traineeRepo.save(trainee);
        Trainee extrainee=traineeRepo.findById(id).orElse(null);
        if(extrainee != null) {
            if(trainee.getName() != null) {
                extrainee.setName(trainee.getName());
            }
            if(trainee.getLocation()!= null) {
                extrainee.setLocation(trainee.getLocation());
            }
            if(trainee.getJoinedDate()!=null) {
                extrainee.setJoinedDate(trainee.getJoinedDate());
            }
            return traineeRepo.save(extrainee);
        }
          throw new RuntimeException("Trainee not found to update");
    }

    @Override
    public Trainee findTraineeByName(String name) {
        return traineeRepo.findByName(name).orElse(null);
    }

    @Override
    public List<Trainee> findTraineeByLocation(String location) {
        return traineeRepo.findByLocation(location);
    }

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Trainee updateTraineeWithProject(int tid, int pid) {
        Project exProject=projectRepository.findById(pid).get();
        Trainee exTrainee= getTraineeById(tid);
        exTrainee.setProject(exProject);
        List<Trainee> al = new ArrayList<>();
        al.add(exTrainee);
        exProject.setTrainees(al);
        projectRepository.save(exProject);
        return traineeRepo.save(exTrainee);
    }

    @Override
    public List<Trainee> findTraineeByMonthAndYear(int month, int year) {
        return traineeRepo.getAllByMonthAndYear(month, year);
    }

}
