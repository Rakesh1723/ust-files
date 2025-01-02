package employeehierarchy.service;

import employeehierarchy.model.Developer;
import employeehierarchy.model.Employee;
import employeehierarchy.model.Manager;

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
       return employees.stream().filter(i -> i.getId() == employeeId).toList().get(0);
         // Placeholder, replace with actual implementation.
    }

    // Todo: Implement a method to calculate total salary expenditure.
    public double calculateTotalSalaryExpenditure() {
        // Todo: Add logic to calculate the total salary expenditure.
        return employees.stream().mapToDouble(i->i.getSalary()).sum();
        // Placeholder, replace with actual implementation.
    }

    // Todo: Implement additional methods for employee management.

    public List<Employee> increment(){

       return employees.stream().peek(i->{
           if(i instanceof Manager) {
             i.setSalary(i.getSalary() + (i.getSalary() * 0.15));
           }
           if(i instanceof Developer) {
               i.setSalary(i.getSalary() + (i.getSalary() * 0.10));
           }
           else {
               i.setSalary(i.getSalary() + (i.getSalary() * 0.05));
           }
       }).toList();

    }

    public void display(){
       employees.forEach(System.out::println);
    }

}
