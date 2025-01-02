package org.springapp.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Network {

    @Value("${network.available}")
    private boolean available;

    public Network(boolean signal) {
        this.available = signal;
    }

    public Network(){
        System.out.println("network");
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "{available=" + available +"}";
    }
}
