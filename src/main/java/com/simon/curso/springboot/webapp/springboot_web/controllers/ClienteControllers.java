package com.simon.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.simon.curso.springboot.webapp.springboot_web.models.User;

@Controller
public class ClienteControllers {

    @GetMapping("/clientes")
    public String details(Model model) {

        User user = new User("Simon", "Bustamante");
        
        model.addAttribute("title", "Hola Mundo Spring Boot!!!");
        model.addAttribute("name", "simon");
        model.addAttribute("lastname", "bustamante");
        model.addAttribute("user", user);
        
        return "details";
    }
}
