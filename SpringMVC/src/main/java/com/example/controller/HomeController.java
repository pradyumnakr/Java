package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Alien;

@Controller
public class HomeController {

    @ModelAttribute
    public void modelData(Model m) {
        m.addAttribute("name", "Pradyumna");
        m.addAttribute("id", "1");
        m.addAttribute("tech", "Java");
        m.addAttribute("marks", "100");
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to Spring MVC!");
        return "home";
    }

    @RequestMapping("add")
    public String add(int num1, int num2, Model model) {
        int result = num1 + num2;
        model.addAttribute("result", result);
        return "result";
    }

    @RequestMapping("addAlien")
    public String addAlien(Alien alien) {
        return "result";
    }
}
