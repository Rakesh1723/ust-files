package com.app.employeehierarchy.model;

import java.util.Random;

public record Employee(long id, String name, String position, double salary) {

    public Employee(String name,String position,double salary) {
        this(new Random().nextLong(100) + 1,name,position,salary);
    }


}
