package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    { Calculator cal=new Calculator();
        // int a=Integer.parseInt(args[0]);
//        int b=Integer.parseInt(args[1]);
//        int sum=a+b;
//        System.out.println(a+" + "+b+" = "+sum);
    float result=cal.divides(5,0);
        System.out.println(result);
    }
}
