package com.simon.curso.springboot.webapp.springboot_web.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.simon.curso.springboot.webapp.springboot_web.models.Product;

@RequestScope //? Sirve para definir el alcance del repository, en este caso es solo para esta peticion/request
//@SessionScope //? Sirve para definir el alcance del repository, en este caso es solo para esta sesion, si se sale de la sesion se reinicia
@Repository("productList")
public class ProductRepositoryImp implements ProductRepository{

    private List<Product> data;

    public ProductRepositoryImp() {
        this.data = Arrays.asList(
            new Product(1L, "Memoria corsair 32", 300L),
            new Product(2L, "Cpu Intel Core  i9", 850L),
            new Product(3L, "Teclado razer mini 60%", 180L),
            new Product(4L, "Motherboard Gigabyte", 490L)
        );
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id) {
        // return data.stream().filter( x -> x.getId().equals(id)).findFirst().orElse(null);
        return data.stream().filter( x -> x.getId().equals(id)).findFirst().orElseThrow();
    }


}
