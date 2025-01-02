package com.app.employeehierarchy;


import com.app.employeehierarchy.model.Developer;
import com.app.employeehierarchy.model.Employee;
import com.app.employeehierarchy.model.Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeHierarchy {

    // TODO: Use Stream API to find the employee with the highest salary
    public static Employee findHighestPaidEmployee(List<Employee> employees) {
        return employees.stream().max((a,b)->Double.compare(a.getSalary(),b.getSalary())).get();
    }


    // TODO: Use Stream API to count the number of developers in the collection
    public static long countDevelopers(List<Employee> employees) {

        return employees.stream().filter(i->i instanceof Developer).count();
    }

    // TODO: Use Stream API to calculate the average salary of all employees
    public static double calculateAverageSalary(List<Employee> employees) {

      double val= employees.stream().map(a->a.getSalary()).reduce(0.0,(a,b)->a+b);
      return val / employees.size();
    }


    public static void main(String[] args) {
        // Create a collection to store employees
        List<Employee> employeeList = new ArrayList<>();

        // TODO: Add sample Manager and Developer instances to the collection
        employeeList.add(new Developer(1,"suhel",1,"c++"));
        employeeList.add(new Manager(2,"amaan",3,3));
        employeeList.add(new Developer(3,"vignay",4,"java"));
        employeeList.add(new Manager(4,"sai",5,2));


        // TODO: Print the initial list of employees
        employeeList.forEach(System.out::println);

        // TODO: Use Stream API to filter employees based on salary range and display the results
        employeeList.stream().filter(i->i.getSalary()>2 && i.getSalary()<4).forEach(System.out::println);

        // TODO: Use Stream API to calculate the total salary of all employees
       System.out.println(employeeList.stream().map(a->a.getSalary()).reduce(0.0,(a,b)->a+b));


        // TODO: Allow user input to add new employees to the collection

        // TODO: Implement a user interface to interact with the program

    }
}
