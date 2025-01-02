package com.ust.webapp.repository;

import com.ust.webapp.model.Trainee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TraineeRepoImpl implements TraineeRepo{

    List<Trainee> al;

    @PostConstruct
    void init(){
        al=new ArrayList<>();
        Trainee t1=new Trainee(1,"rakesh","Hyderabad");
        Trainee t2=new Trainee(2,"ram","warangal");
        al.add(t1);
        al.add(t2);
    }

    @Override
    public Trainee addTrainee(Trainee trainee) {
        al.add(trainee);
        return trainee;
    }

    @Override
    public Optional<Trainee> getTrainee(int id) {
        return al.stream().filter(i->i.getId() == id).findFirst();
    }

    @Override
    public List<Trainee> getAllTrainees() {
        return al;
    }

    @Override
    public void deleteTrainee(int id) {
         // al.remove(al.stream().filter(i->i.id() == id).findFirst().get());
        al.removeIf(i->i.getId()==id);
    }

    @Override
    public Trainee updateTrainee(int id, Trainee trainee) {
        Trainee savedTrainee = getTrainee(id).orElseThrow();
        savedTrainee.setName(trainee.getName());
        savedTrainee.setLocation(trainee.getLocation());
        return savedTrainee;
    }

}
