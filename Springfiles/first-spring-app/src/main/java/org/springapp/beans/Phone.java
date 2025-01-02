package org.springapp.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
@Scope("singleton") //by default
public class Phone {


    public Phone(){
        System.out.println("phone");
    }


//    @Autowired(required = false)  // to make it as an optional.
    @Autowired
    private Sim sim;

    //not possible to inject dependency to value type.
    @Value("${phone.brand}")
    private String brand;
    @Value("${phone.model}")
    private String model;
    @Value("${phone.price}")
    private double price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public Phone(Sim sim) {
        this.sim = sim;
    }

    public Sim getSim() {
        return sim;
    }

    public void setSim(Sim sim) {
        this.sim = sim;
    }

    public void call(String phnNo){
        sim.call(phnNo);
    }

    public void sendText(String phnNo,String message){
        sim.sendText(phnNo,message);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "sim=" + sim +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
