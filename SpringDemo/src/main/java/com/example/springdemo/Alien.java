package com.example.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Alien {

    // public Alien() {
    // System.out.println("Alien object created");
    // }

    @Autowired
    public Alien(@Value("28") int age) {
        this.age = age;
    }

    @Value("28")
    private int age;

    @Autowired
    @org.springframework.beans.factory.annotation.Qualifier("laptop")
    private Computer computer;

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void code() {
        System.out.println("I'm coding...");
        computer.compile();
    }
}
