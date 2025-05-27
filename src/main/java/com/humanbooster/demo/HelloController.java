package com.humanbooster.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello(){
        return "Acceuil de l'Application";
    }

    @GetMapping("/hello")
    public String helloWorld(){
        return "<h2>Hello World!</h2>";
    }
}
