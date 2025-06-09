package com.simon.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simon.curso.springboot.webapp.springboot_web.models.User;
import com.simon.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;
    
    // @Value("${config.menssage}")
    // private String menssage;
    
    @Value("${config.listOfValue}")
    private List<String> listOfValue;
    
    @Value("${config.code}")
    private Integer code;
    
    //convertir a un array de string manual
    @Value("#{ '${config.listOfValue}'.split(',') }")
    private List<String> valueList;

    //convertir a string manual
    @Value("#{ '${config.listOfValue}' }")
    private String valueString;
    
    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {
        //! Esto si aca, los parametros son obligatorios, y el nombre debe ser igual
        
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);

        return paramDto;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String,Object> mix(
        @PathVariable String product,
        @PathVariable Long id
    ) {
        //! Esto si aca, los parametros son obligatorios, y el nombre debe ser igual
        
        Map<String,Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);

        return json;
    }

    @PostMapping("/create")
    public User create(
        @RequestBody User user
    ) {
        // Para guardarlo en la BBDD o hacer algo mas

        user.setName(user.getName().toUpperCase());

        return user;
    }
    
    @GetMapping("/values")
    public Map<String, Object> values( @Value("${config.menssage}") String menssage) {
        // Para guardarlo en la BBDD o hacer algo mas

        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("message", menssage);
        json.put("listOfValue", listOfValue);
        json.put("code", code);
        json.put("valueList", valueList);
        json.put("valueString", valueString);

        return json;
    }
}
