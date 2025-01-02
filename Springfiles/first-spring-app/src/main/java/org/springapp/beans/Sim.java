package org.springapp.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component // equivalent to bean creation so that spring will create bean.
public class Sim {

    @Autowired //automatically it inject dependency
  //  @Qualifier("networkAvailable")// used to differentiate multiple bean of same type . another way is  it checks name of the data
    private Network network;

    @Value("${network.provideName}")
    private String providerName;

    public Sim(){
        System.out.println("sim");
    }

    public void call(String phnNo){
        if(network.isAvailable())
          System.out.println("Calling "+phnNo);
        else
          System.out.println("Couldn't make a call due to network issues");
    }
    public void sendText(String phnNo,String message){
        if(network.isAvailable())
          System.out.println("""
                           Sent
                           %s
                           to %s
                          """.formatted(message,phnNo));
        else
            System.out.println("Couldn't make a call due to network issues");
    }

    @Override
    public String toString() {
        return "{network=" + network +
                ", providerName='" + providerName +"}" ;
    }
}
