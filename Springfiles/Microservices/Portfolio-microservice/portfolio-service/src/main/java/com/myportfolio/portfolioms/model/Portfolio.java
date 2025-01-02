package com.myportfolio.portfolioms.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Portfolio {
    @Id
    private String id;
    private String name;
    @ElementCollection // alternative to one to many
    private Set<Integer> stocks;
    @ElementCollection
    private  Set<Integer> mutualFunds;

    @Transient //not save in db
    private double totalValue;

}
