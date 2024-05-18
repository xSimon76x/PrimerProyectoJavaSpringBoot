package com.simon.curso.springboot.webapp.springbootweb.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.simon.curso.springboot.webapp.springbootweb.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model){

        User user = new User("Simon", "Bustamante");

        model.addAttribute("title", "Hola mundo Spring Boot");
        model.addAttribute("user", user);

        //Este string que retorna ("details") debe ser el nombre del template
        //Para que reconosca esa plantilla para entregarle los datos
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
