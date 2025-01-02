package exceptionhandling;

import java.util.Scanner;

public class ThrowingAnException {

    public  static int readAge() throws CustomInvalidAgeException {  // throws is used to declare this method throws exp(doesn't want to handle) and calling method must be handle exp
        System.out.println("Input your age: ");
       int  age=new Scanner(System.in).nextInt();
        if(age<=0||age>100)
        {
          //  throw new RuntimeException("Sorry Invalid Age"); // intentionally throwing an exp.
            throw new CustomInvalidAgeException("Sorry Invalid Age");
        }
        return age;
    }
    public static void main(String[] args) {
        int age=0;
        try{
            age=readAge();
        }catch(Exception ex){
           // throw new RuntimeException("Sorry Invalid Age entered");
            System.err.println(ex);
        }
        System.out.println("Age : "+age);
    }
}
