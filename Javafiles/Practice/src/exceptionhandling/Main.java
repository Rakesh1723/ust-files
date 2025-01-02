package exceptionhandling;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Everyone...");
        System.out.println("we are doing some math operations : ");
        int a=10,b=0;
        System.out.println("Trying to division operation : ");
        try {
            int divOutput = a / b;
            System.out.println("Result of Division: " + divOutput);
        }
        catch(ArithmeticException ex){
//            System.err.println("Cannot  divide by zero");

        }
        System.out.println("Trying to multiplication operation : ");
        int productOutput=a*b;
        System.out.println("Result of multiplication: "+productOutput);

        System.out.println("All Done");
        System.out.println("Bye...");
    }
}
