package employeehierarchy;

import employeehierarchy.model.Developer;
import employeehierarchy.model.Employee;
import employeehierarchy.model.Manager;
import employeehierarchy.model.RegularEmp;
import employeehierarchy.service.EmployeeHierarchyService;

import java.util.Random;

public class EmployeeHierarchyMain {

    public static void main(String[] args) {

        EmployeeHierarchyService service = new EmployeeHierarchyService();

        // Todo: Add employees to the system.
        service.addEmployee(new Manager(1, "John Doe", "Manager", 60000.0));
        service.addEmployee(new Developer(rand(), "Jane Smith", "Developer", 50000.0));
        service.addEmployee(new RegularEmp(rand(),"sai","RegularEmp",30000.0));

        // Todo: Retrieve and display employee information.
        Employee retrievedEmployee = service.getEmployeeById(1);
        System.out.println("Retrieved Employee: " + retrievedEmployee);

        // Todo: Calculate and display total salary expenditure.
        double totalSalaryExpenditure = service.calculateTotalSalaryExpenditure();
        System.out.println("Total Salary Expenditure: $" + totalSalaryExpenditure);

        // Todo: Perform additional operations as needed.
        System.out.println("Before increment : ");
        service.display();
        service.increment();
        System.out.println("After increment : ");
        service.display();
    }

    public static long rand(){
        return new Random().nextLong(100)+1;
    }

}
