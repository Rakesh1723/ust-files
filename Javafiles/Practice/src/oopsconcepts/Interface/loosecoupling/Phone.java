package oopsconcepts.Interface.loosecoupling;

public class Phone {

   // Sim sim=new AirtelSim();
    Sim sim;
    Phone(Sim sim)
    {
        this.sim=sim;
    }


    public void browse()
    {
        sim.browseInternet();
    }
    public void call()
    {
        sim.call();
    }

}
