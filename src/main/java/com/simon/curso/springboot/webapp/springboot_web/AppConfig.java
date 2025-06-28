package com.simon.curso.springboot.webapp.springboot_web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.simon.curso.springboot.webapp.springboot_web.controllers.ProductRepositoryJson;
import com.simon.curso.springboot.webapp.springboot_web.repositories.ProductRepository;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Bean
    ProductRepository productRepositoryJson() {
        return new ProductRepositoryJson();
    }

}
