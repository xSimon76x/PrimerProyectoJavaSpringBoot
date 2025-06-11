package com.simon.curso.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simon.curso.springboot.webapp.springboot_web.models.User;
import com.simon.curso.springboot.webapp.springboot_web.models.dto.UserDto;

@RestController
@RequestMapping("/user")
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

    @GetMapping("/details-dto")
    public UserDto detailsDto(Model model) {

        UserDto userDto = new UserDto();
        User user = new User("Simon", "Bustamante");
        
        userDto.setUser(user);
        userDto.setTitle("Un nuevo dto");
        
        return userDto;
    }
    
    @GetMapping("/details-dto-list")
    public List<User> list() {
        // Lista de objetos
        User user1 = new User("Simon", "Bustamante");
        User user2 = new User("Ivan", "Bustamante");
        User user3 = new User("Toji", "Bustamante");

        // List<User> users = new ArrayList<>();
        // users.add(user1);
        // users.add(user2);
        // users.add(user3);
        List<User> users = Arrays.asList(user1, user2, user3);

        return users;
    }
    

}
