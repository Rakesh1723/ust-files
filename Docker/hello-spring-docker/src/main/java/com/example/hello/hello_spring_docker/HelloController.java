package com.example.hello.hello_spring_docker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping
    public String getMessage(){
        return "Hello ust, welcome to Docker";
    }
}
