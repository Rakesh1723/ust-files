package com.ust.traineeapp.repository;

import com.ust.traineeapp.model.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TraineeRepository  extends JpaRepository<Trainee,Integer> {  // <model name,primary key type>

  //  @Query("from Trainee where name=:name") // manual generation then any method name is fine. //JPQL queries .
    Optional<Trainee> findByName(String name); // method name is a particular way.


    @Query(value="select * from trainee_db where extract(month from joined_date)=:month and extract(year from joined_date)=:year",nativeQuery = true)
    public List<Trainee> getAllByMonthAndYear(int month,int year);

    @Query(name = "findByLocation")  //named query
    public List<Trainee> findByLocation(String location);
}
