package com.app.employeehierarchy.service;

import com.app.employeehierarchy.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeHierarchyService {

    private List<Employee> employees =new ArrayList<>();

    // Todo: Implement a method to add an employee to the system.
    public void addEmployee(Employee employee) {
        // Todo: Add logic to add an employee to the system.
        employees.add(employee);
    }

    // Todo: Implement a method to get an employee by ID.
    public Employee getEmployeeById(int employeeId) {
        // Todo: Add logic to retrieve an employee by ID.
       return employees.stream().filter(i -> i.id() == employeeId).findFirst().get();
         // Placeholder, replace with actual implementation.
    }

    // Todo: Implement a method to calculate total salary expenditure.
    public double calculateTotalSalaryExpenditure() {
        // Todo: Add logic to calculate the total salary expenditure.
        return employees.stream().mapToDouble(i->i.salary()).sum();
        // Placeholder, replace with actual implementation.
    }

    // Todo: Implement additional methods for employee management.

    public double increment(int id){
        Employee e=getEmployeeById(id);
        if(e.position().equalsIgnoreCase("manager"))
            return e.salary()+(e.salary()*0.15);
        else if(e.position().equalsIgnoreCase("Developer"))
            return e.salary()+(e.salary()*0.10);
        else
            return e.salary()+(e.salary()*0.05);
    }

    public void display(){
        System.out.println(employees);
    }

}
