package com.simon.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simon.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/all-params")
    public ParamDto bar( HttpServletRequest req) 
    {
        // /all-params?meg=hola&code=2
        ParamDto param = new ParamDto();
        param.setMessage(req.getParameter("meg"));
        param.setCode(Integer.parseInt(req.getParameter("code")));

        return param;
    }
    
}
