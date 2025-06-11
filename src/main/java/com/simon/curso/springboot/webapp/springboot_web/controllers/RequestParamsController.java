package com.simon.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import com.simon.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto ParamDto(
        @RequestParam(
            required = false, 
            defaultValue = "mensaje por defecto",
            name = "paramMensaje"
        ) String message
    ) {
        // /foo?paramMensaje=hola%20como%20estas
        ParamDto param = new ParamDto();
        param.setMessage( message );
        
        return param;
    }
    
    @GetMapping("/bar")
    public ParamDto bar(
        @RequestParam String text,
        @RequestParam(required = false) Integer code
        ) 
    {
        // /bar?text=hola%20como%20estas&code=1
        ParamDto param = new ParamDto();
        param.setMessage(text);
        param.setCode(code);

        return param;
    }

    @GetMapping("/all-params/{edad}")
    public ResponseEntity<?> bar( HttpServletRequest req, @PathVariable String edad) 
    {
        // /all-params?meg=hola&code=2
        // ParamDto param = new ParamDto();
        // param.setMessage(req.getParameter("meg"));
        // param.setCode(Integer.parseInt(req.getParameter("code")));

        // return param;

        //Combinar en un objeto de salida, las PathVariables y lo del requestBody
        Map<String, String> pathVars = (Map<String, String>) req.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

        Map<String, String[]> paramMap = req.getParameterMap();

        Map<String, String> combined = new HashMap<>();

        if (pathVars != null) {
            combined.putAll(pathVars);
        }

        for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
            // Si hay múltiples valores, los unes con coma
            combined.put(entry.getKey(), String.join(",", entry.getValue()));
        }


        return ResponseEntity.ok(combined);
    }
    
}
