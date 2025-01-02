package employee;

public class Developer extends Employee{
    String programmingLanguage;

    public Developer(String name,int EmployeeID,double salary,String programmingLanguage) {
        super(name,EmployeeID,salary);
        this.programmingLanguage = programmingLanguage;
    }
    void displayDetails()
    {   super.displayDetails();
        System.out.println("ProgrammingLanguage: "+programmingLanguage);
    }

    public void report()
    {
        System.out.println("I report to manager");
    }


}
