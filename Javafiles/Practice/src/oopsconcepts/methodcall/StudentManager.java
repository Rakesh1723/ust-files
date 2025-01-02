package oopsconcepts.methodcall;

public class StudentManager {

    public static void updateStudent(Student s,String branch)
    {
      //  s.branch=branch;  // -- java follows call by value
      //  s=null;          // -- java doesn't support call by reference
        s=new Student();
        s.branch=branch;
    }

    public static void main(String[] args) {
        Student s1=new Student();
        s1.branch="CSE";
        System.out.println(s1.branch);
        updateStudent(s1,"ECE");
        System.out.println(s1.branch);
    }
}
