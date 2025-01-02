package com.ust.webapp.controller;

import com.ust.webapp.dto.TraineeDto;
import com.ust.webapp.model.Trainee;
import com.ust.webapp.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TraineeController {

    @Autowired
    TraineeService traineeServiceImpl;

    @PostMapping("/add-trainee")  // verbs are used for views
    public void addTrainee(Model m, @RequestParam("id") int id,@RequestParam("name") String name, @RequestParam("location") String location){
        TraineeDto trainee=new TraineeDto(id,name,location);
        traineeServiceImpl.addTrainee(trainee);
    }

    @GetMapping("/view-trainee")
    public String getAllTrainees(Model m){
        List<TraineeDto> al=  traineeServiceImpl.getAllTrainees();
        m.addAttribute("trainees",al);
        return "view-trainee.jsp";
    }

    @GetMapping("/get-trainee")
    public String getTraineeById(Model m,@RequestParam("id") int id){
        List<TraineeDto> al=new ArrayList<>();
        al.add(traineeServiceImpl.getTrainee(id));
        m.addAttribute("trainees",al);
        return "view-trainee.jsp";
    }

    @DeleteMapping("/delete-trainee")
    public String deleteById(Model m, @RequestParam("id") int id){
        traineeServiceImpl.deleteTrainee(id);
        m.addAttribute("trainees", traineeServiceImpl.getAllTrainees());
//      m.addAttribute("trainees",traineeServiceImpl.getAllTrainees());
        return  "view-trainee.jsp";

    }




//    @GetMapping("/get-trainee")
//    public String getAllTrainee(Model m){
//      List<Trainee> al=  traineeServiceImpl.getAllTrainee();
//      m.addAttribute("trainees",al);
//        return "view-trainee.jsp";
//    }

//    @PostMapping("/add-trainee")
//    public String addTrainee(@ModelAttribute("trainee") Trainee trainee){
//        return "view-trainee.jsp";
//    }

}
