package com.simon.curso.springboot.webapp.springboot_web.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simon.curso.springboot.webapp.springboot_web.models.Product;
import com.simon.curso.springboot.webapp.springboot_web.repositories.ProductServices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api")
public class SomeControllers {

    private ProductServices service = new ProductServices();

    @GetMapping
    public List<Product> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
        return service.findById(id);
    }
     
}
