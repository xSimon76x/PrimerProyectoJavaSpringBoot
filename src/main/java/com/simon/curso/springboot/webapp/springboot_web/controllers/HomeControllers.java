package com.simon.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeControllers {

    @GetMapping({"", "/", "home"})
    public String home() {

        //Redirigir a otra ruta web
        
        //Consideraciones:
        //Cambia la ruta, reinicia el request y refresca el navegador
        //Parametros que teniamos antes de hacer el request, se pierden
        // return "redirect:/details";
        
        // Consideraciones:
        // No cambia la ruta, no reinicia el request, no refresca el navegador
        // No se pierden los parametros, sino que despacha a otra accion del controlador
        return "forward:/details";
    }
    
}
