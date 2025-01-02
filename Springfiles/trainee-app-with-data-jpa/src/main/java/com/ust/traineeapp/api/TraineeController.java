package com.ust.traineeapp.api;

import com.ust.traineeapp.model.Project;
import com.ust.traineeapp.model.Trainee;
import com.ust.traineeapp.repository.ProjectRepository;
import com.ust.traineeapp.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://127.0.0.1:5500"})
@RestController
@RequestMapping("/api/v1/trainees")
public class TraineeController {

    @Autowired
    private TraineeService traineeService;

    @Autowired
    private ProjectRepository projectRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Trainee saveTrainee(@RequestBody Trainee trainee){
        return  traineeService.saveTrainee(trainee);
    }

    @PostMapping("/project")
    public Project saveProject(@RequestBody Project project){
        return  traineeService.saveProject(project);
    }

    @PutMapping("/AddProject/{tid}/{pid}")
    public Trainee updateTraineeWithProject(@PathVariable("tid") int tid,@PathVariable("pid") int pid){
        return  traineeService.updateTraineeWithProject(tid,pid);
    }

    @GetMapping("/{id}")
    public Trainee gettrainee(@PathVariable("id") int id){
        return traineeService.getTraineeById(id);
    }

    @GetMapping
    public List<Trainee> getAllTrainee(){
        return traineeService.getAllTrainee();
    }

    @PutMapping("/{id}")
    public Trainee updateTrainee(@PathVariable("id") int id, @RequestBody Trainee trainee){
        return  traineeService.updateTrainee(id,trainee);
    }

    @DeleteMapping("/{id}")
    public void deleteTrainee(@PathVariable("id") int id)
    {
        traineeService.deleteTrainee(id);
    }

    @GetMapping("/name")
    @ResponseStatus(code = HttpStatus.OK)
    public Trainee findByName(@RequestParam("name") String name){
       return traineeService.findTraineeByName(name);
    }

    @GetMapping("/location")
    public List<Trainee> findByLocation(@RequestParam("location") String location){
        return traineeService.findTraineeByLocation(location);
    }

    @GetMapping("/month/{month}/year/{year}")
    public List<Trainee> findTraineeByMonthAndYear(@PathVariable int month,@PathVariable int year){
        return traineeService.findTraineeByMonthAndYear(month,year);
    }

    @GetMapping("/project")
    public List<Project> getProject(){
        return  projectRepository.findAll();
    }

}
