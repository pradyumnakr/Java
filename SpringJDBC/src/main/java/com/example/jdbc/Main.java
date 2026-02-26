package com.example.jdbc;

import com.example.jdbc.config.JdbcConfig;
import com.example.jdbc.model.Alien;
import com.example.jdbc.repo.AlienDAO;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {
    public static void main(String[] args) {
        // Load the Spring context based on the Java configuration class
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

        Alien alien = context.getBean(Alien.class);
        alien.setId(1);
        alien.setName("John");
        alien.setLanguage("Java");

        AlienDAO alienDAO = context.getBean(AlienDAO.class);
        alienDAO.addAlien(alien);

        System.out.println("Alien added successfully!");
        System.out.println("Fetching all aliens...");

        System.out.println(alienDAO.getAllAliens());
    }

}
