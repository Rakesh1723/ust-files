package oopsconcepts.Interface;

public class CanonPrinter implements Printable,Scannable{

    public void print() {
        System.out.println("Hello CanonPrinter");
    }

    public void scan() {
        System.out.println("Scanning with canon");
    }

}
