package org.springapp.configuration;

import org.springapp.beans.Network;
import org.springapp.beans.Phone;
import org.springapp.beans.Sim;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "org.springapp") // used to scan package and create beans for component.
@PropertySource("app.properties")
public class AppConfig {

//    @Bean   // method level configuration
//    public Sim getSimBean(){
//        return new Sim();
//    }
//
//    @Bean("iPhone")
//    public Phone getIPhoneBean(){
//          Phone phone=new Phone();
//          phone.setBrand("Apple");
//          phone.setModel("iphone 16 pro");
//          phone.setPrice(119999);
//          return phone;
//    }
//
//    @Bean("Pixel")
//    public Phone getPixelBean(){
//        Phone phone=new Phone();
//        phone.setBrand("Google");
//        phone.setModel("Google Pixel 8");
//        phone.setPrice(37999);
//        return phone;
//    }
//
//    @Bean("networkAvailable")
//    public Network getNetworkBean(){
//         return new Network(true);
//     }
//
//    @Bean("networkNotAvailable")
//    public Network getNoNetworkBean(){
//        return new Network(false);
//    }



}
