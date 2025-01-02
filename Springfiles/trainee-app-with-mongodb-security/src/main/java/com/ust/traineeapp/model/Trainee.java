package com.ust.traineeapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;
import java.time.LocalDate;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Trainee {

    @Id
    private BigInteger id;
    private String name;
    private String location;
//   @Field(name="date_joined")
    private LocalDate joinedDate;
    private Project project;

}
