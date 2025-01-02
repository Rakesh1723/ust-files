package com.ust.traineeapp.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // to map Trainee to table in db
@Table(name="trainee_db") // to set table name optional.
//named query
@NamedQueries(
        {@NamedQuery(query = "from Trainee where location=:location", name = "findByLocation")}
)
public class Trainee {
    @Id // to set  primary key
  //  @GeneratedValue(strategy = GenerationType.AUTO) // to increment id optional field
    @Column(name="trainee_id") // to set name optional field
 //   @JsonProperty("trainee_id")   // to set json name.
    private int id;
    @Column(name="trainee_name",length=50)
    private String name;
    @Column(length=100)
    private String location;
    @Column(name="joined_date")
  //  @JsonFormat(pattern = "dd/MMM/yyyy")  //to set date format
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy") //to set date format
    private LocalDate joinedDate;

//    @OneToOne(cascade=CascadeType.ALL) //it will create foreign key constrain and relation table create first i.e project(cascade is used)
//    private Project project;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
//    @JoinTable(
//            name = "project_trainees",  // Name of the join table
//            joinColumns = @JoinColumn(name = "project_id"), // Column in the join table referencing the Project
//            inverseJoinColumns = @JoinColumn(name = "trainee_id") // Column in the join table referencing the Task
//    )

    @ManyToOne(cascade = CascadeType.ALL)
    private Project project;

}
