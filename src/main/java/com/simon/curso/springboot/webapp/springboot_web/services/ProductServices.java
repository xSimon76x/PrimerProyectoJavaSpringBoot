package com.simon.curso.springboot.webapp.springboot_web.services;

import java.util.List;

import com.simon.curso.springboot.webapp.springboot_web.models.Product;

public interface ProductServices {

    List<Product> findAll();

    Product findById(Long id);

}
