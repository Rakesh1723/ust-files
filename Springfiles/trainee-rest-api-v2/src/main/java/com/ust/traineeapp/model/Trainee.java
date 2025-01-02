package com.ust.traineeapp.model;


import jakarta.persistence.*;
        import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="trainee_db")
public class Trainee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="trainee_id")
    private int id;
    @Column(name="trainee_name",length=50)
    private String name;
    @Column(length=100)
    private String location;
    @Column(name="joined_date")
    private LocalDate joinedDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private Project project;

}

