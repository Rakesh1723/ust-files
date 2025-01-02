package com.myportfolio.portfolioms.Config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    @LoadBalanced
    //@Primary
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

//    @Bean
//    @Qualifier("basic")
//    public RestTemplate getRestTemplate(){
//        return new RestTemplate();
//    }

}
