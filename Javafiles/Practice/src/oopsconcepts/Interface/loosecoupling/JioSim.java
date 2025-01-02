package oopsconcepts.Interface.loosecoupling;

public class JioSim implements Sim{

    public void call(){
        System.out.println("Calling with JioSim");
    }

    public void browseInternet(){
        System.out.println("Browsing internet with JioSim");
    }

}
