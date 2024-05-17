package com.simon.curso.springboot.webapp.springbootweb.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model){

        model.addAttribute("title", "Hola mundo Spring Boot");
        model.addAttribute("name", "Simon");
        model.addAttribute("lastname", "Bustamante");

        return "details";
    }

    @GetMapping("/details2")
    public String detailsFormaDos(Map<String, Object> model){

        model.put("title", "Hola mundo Spring Boot");
        model.put("name", "Simon");
        model.put("lastname", "Bustamante");

        return "details";
    }

}
