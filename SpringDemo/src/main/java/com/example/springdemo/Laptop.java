package com.example.springdemo;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {

    public void compile() {
        System.out.println("I'm compiling...");
    }

}
