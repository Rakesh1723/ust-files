package employee;

public  abstract class Employee {
    String name;
    int employeeID;
    double salary;

    public Employee(){
    }

    public Employee(String name, int employeeID, double salary) {
        this.name = name;
        this.employeeID = employeeID;
        this.salary = salary;
    }

    void displayDetails()
    {
        System.out.println(this.getClass().getSimpleName()+"employee details:"+"\nName:"+name+"\nEmployee ID: "+employeeID+"\nsalary:"+salary);
    }
   //  this.getClass().getSimpleName() -- to get class properties.(reflection access all modifiers)

    public abstract void report();
}
