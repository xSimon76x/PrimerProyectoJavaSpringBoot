package com.simon.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simon.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/var")
public class PathVariableController {

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
    
}
