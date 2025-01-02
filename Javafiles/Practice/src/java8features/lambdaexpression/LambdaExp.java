package java8features.lambdaexpression;

interface Printer{
    void print(String str);
    default void scan(){

    }
}
public class LambdaExp {
    public static void main(String[] args) {
        Printer obj=(String str)-> System.out.println(str);
        // Printer obj=s-> System.out.println(str);
        obj.print("hello");
    }
}
