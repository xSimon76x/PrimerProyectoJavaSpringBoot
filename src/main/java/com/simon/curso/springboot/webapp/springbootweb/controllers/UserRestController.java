package com.simon.curso.springboot.webapp.springbootweb.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simon.curso.springboot.webapp.springbootweb.models.User;
import com.simon.curso.springboot.webapp.springbootweb.models.dto.UserDto;


//Importando este decorador, puedo transformar una clase para que contenga APIs Rest
@RestController
@RequestMapping("/api")//Esto es una ruta base: /api/details-rest
public class UserRestController {

    //GetMapping es una abreviatura de RequestMapping, 
    //ya que el valor por defecto del RequestMapping es el GetMapping
    //@GetMapping("/details-rest") -> @RequestMapping(path="/details-rest", method=RequestMethod.GET)
    @GetMapping("/details-rest-map")
    public Map<String, Object> detailsMap(){

        Map<String, Object> body = new HashMap<>();
        User user = new User("Simon", "Bustamante");

        body.put("title", "Hola mundo Spring Boot");
        body.put("user", user);

        return body;
    }

    @GetMapping("/details-rest-dto")
    public UserDto detailsDto(){

        //TODO Usar una clase POJO para poder almacenar la data a mostrar en el APIrest
        UserDto userDto = new UserDto();
        User user = new User("Simon", "Bustamante");

        userDto.setUser(user);
        userDto.setTitle("Hola mundo Spring Boot Dto");

        return userDto;
    }


}
