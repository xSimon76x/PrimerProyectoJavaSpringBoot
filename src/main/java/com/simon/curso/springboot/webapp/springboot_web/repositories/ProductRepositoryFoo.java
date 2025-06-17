package com.simon.curso.springboot.webapp.springboot_web.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.simon.curso.springboot.webapp.springboot_web.models.Product;

// Solo puede haber un @Primary no pueden haber mas
@Primary // Con esta anotacion se define como el repositorio primario a utilizar, y los demas quedan inutilizados si
@Repository
public class ProductRepositoryFoo implements ProductRepository{



    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Monitor Asus 27", 600L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(1L, "Monitor Asus 27", 600L);
    }

}
