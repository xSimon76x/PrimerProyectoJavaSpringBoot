package com.simon.curso.springboot.webapp.springbootweb.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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

    @GetMapping("/list")   
    public String list(ModelMap model){
        
        
        // Se agrega un usuario
        // User user1 = new User("simon", "bustamante");
        // users.add(user1);
    
        // model.addAttribute("users", users);
        model.addAttribute("title", "Listado de usuarios");

        return "list";
    }

    //users: esta variable es la usada en el template list.html
    //de esta forma puedo reutilizar esta misma variable en otro tempalte
    @ModelAttribute("users")
    public List<User> usersModel() {

        List<User> users = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            users.add(new User("simon"+i, "bustamante"+i, "sb"+i+"@gmail.com"));
        }
        users.add(new User("andres", "panza"));

        return users;
    }

}
