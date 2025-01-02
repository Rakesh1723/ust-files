package employee;

public class Manager extends Employee {
    int teamSize;

    public Manager(String name,int EmployeeID,double salary,int teamSize) {
        super(name,EmployeeID,salary);
        this.teamSize = teamSize;
    }
    void displayDetails()
    {   super.displayDetails();
        System.out.println("TeamSize: "+teamSize);
    }

    public void report()
    {
        System.out.println("I report to ceo");
    }
}
