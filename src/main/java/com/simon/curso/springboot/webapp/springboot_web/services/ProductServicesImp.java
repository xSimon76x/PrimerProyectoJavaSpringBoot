package com.simon.curso.springboot.webapp.springboot_web.services;

import java.util.List;
import java.util.stream.Collectors;

import com.simon.curso.springboot.webapp.springboot_web.models.Product;

// En el service, se utilizan los metodos que fueron creados en el Repository
// para implementar la logica de negocio, luego de hacer X accion (GET,PUT, etc)
// que se definicion en el repository, y que esta entrega un resultado
// que puede ser moldeado en el service 
public class ProductServicesImp  implements ProductServices{

    private ProductServicesImp repository = new ProductServicesImp();

    public List<Product> findAll() {
        return repository.findAll().stream().map( x -> {
            Double priceImp = x.getPrice() * 1.25d;
            Product newProd = (Product) x.clone();
            newProd.setPrice(priceImp.longValue());

            return newProd;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id) {
        return repository.findById(id);
    }
    
}
