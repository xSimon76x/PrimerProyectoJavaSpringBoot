package com.simon.curso.springboot.webapp.springboot_web.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.simon.curso.springboot.webapp.springboot_web.models.Product;
import com.simon.curso.springboot.webapp.springboot_web.repositories.ProductRepository;

// En el service, se utilizan los metodos que fueron creados en el Repository
// para implementar la logica de negocio, luego de hacer X accion (GET,PUT, etc)
// que se definicion en el repository, y que esta entrega un resultado
// que puede ser moldeado en el service 
@Service
public class ProductServicesImp  implements ProductServices{

    @Autowired
    @Qualifier("productList")
    private ProductRepository repository; // Con Autowired evitamos usar el '= new ProductServicesImp();'

    // En vez de considerar al Primary, se esta seleccionado la clase que es usada por dicha interfaz
    // En este caso ProductRepositoryImp
    //! El Qualifier no filtra por repository dentro de los parametros del constructor
    public ProductServicesImp( @Qualifier("productList") ProductRepository repository ) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map( x -> {
            Double priceImp = x.getPrice() * 1.25d;
            Product newProd = (Product) x.clone();
            newProd.setPrice(priceImp.longValue());
            // x.setPrice(priceImp.longValue());
            return newProd;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }
    
}
