package com.simon.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simon.curso.springboot.webapp.springboot_web.models.User;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public Map<String, Object> details(Model model) {

        Map<String, Object> body = new HashMap<>();
        User user = new User("Simon", "Bustamante");
        
        body.put("title", "Hola Mundo Spring Boot!!!");
        body.put("name", "simon");
        body.put("lastname", "bustamante");
        body.put("user", user);
        
        return body;
    }

    @GetMapping("/details-models")
    public User detailsModels(Model model) {

        User user = new User("Simon", "Bustamante");
        
        return user;
    }

}
