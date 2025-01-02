package oopsconcepts.Interface;

public class Main {
    public static void main(String[] args) {
        Printable printer=new CanonPrinter(); //loose couple , allows us to change to any printer.
        CanonPrinter p=new CanonPrinter(); //tight couple
        printer.print();
    }
}
