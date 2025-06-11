package com.simon.curso.springboot.webapp.springboot_web.repositories;

import java.util.Arrays;
import java.util.List;

import com.simon.curso.springboot.webapp.springboot_web.models.Product;

public class ProductRepository {

    private List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
            new Product(1L, "Memoria corsair 32", 300L),
            new Product(2L, "Cpu Intel Core  i9", 850L),
            new Product(3L, "Teclado razer mini 60%", 180L),
            new Product(4L, "Motherboard Gigabyte", 490L)
        );
    }

    public List<Product> findAll() {
        return data;
    }

    public Product findById(Long id) {
        // return data.stream().filter( x -> x.getId().equals(id)).findFirst().orElse(null);
        return data.stream().filter( x -> x.getId().equals(id)).findFirst().orElseThrow();
    }


}
