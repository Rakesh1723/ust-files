package com.ust.webapp.controller;

import com.ust.webapp.dto.TraineeDto;
import com.ust.webapp.model.Trainee;
import com.ust.webapp.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //combination of rest and controller.
@RequestMapping("/api/v1/trainees") //it will handle any type of request
public class TraineeRestController {

    @Autowired
    private TraineeService traineeService;

    @GetMapping("/{id}") // nouns are used for resources
   // @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<TraineeDto> getTrainee(@PathVariable("id") int id){
          if(traineeService.getTrainee(id) != null)
             return ResponseEntity.status(HttpStatus.OK).body(traineeService.getTrainee(id));
          else
              return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<TraineeDto> getAllTrainee(){
        return traineeService.getAllTrainees();
    }

    @PostMapping
    //@ResponseStatus(code= HttpStatus.CREATED)
    public ResponseEntity<TraineeDto> saveTrainee(@RequestBody TraineeDto trainee){ //converting/mapping json to java
       TraineeDto savedTrainee = traineeService.addTrainee(trainee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTrainee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrainee(@PathVariable("id") int id){
        traineeService.deleteTrainee(id);
    }

    @GetMapping("/name")
    @ResponseStatus(code = HttpStatus.OK)
    public TraineeDto getTraineeByName(@RequestParam("name") String name){
        return traineeService.getAllTrainees().stream().filter(i->i.name().equalsIgnoreCase(name)).findFirst().get();
    }

//    @GetMapping("/name/{name}")
//    public Trainee getTraineeByName(@PathVariable("name") String name){
//        return traineeService.getAllTrainees().stream().filter(i->i.name().equalsIgnoreCase(name)).findFirst().get();
//    }

    @PutMapping("/{id}")
    @ResponseStatus(code=HttpStatus.ACCEPTED)
    public TraineeDto updateTrainee(@PathVariable("id") int id,@RequestBody TraineeDto trainee)
    {
        return traineeService.updateTrainee(id,trainee);
    }

}
