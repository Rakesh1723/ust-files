package oopsconcepts.Interface.loosecoupling;

public class Main {
    public static void main(String[] args) {
        Phone p=new Phone(new AirtelSim());
        p.browse();
        p.call();

    }
}
