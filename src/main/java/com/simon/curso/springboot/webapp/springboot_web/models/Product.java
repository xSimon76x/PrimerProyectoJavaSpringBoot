package com.simon.curso.springboot.webapp.springboot_web.models;

public class Product implements Cloneable {

    private Long id;
    private String name;
    private Long price;

    public Product() {}
    
    public Product(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getPrice() {
        return price;
    }
    public void setPrice(Long price) {
        this.price = price;
    }

  @Override
  public Object clone() {
    // Para evitar que sea mutable el Product
    // Clona el objeto y se usa despues para hacer acciones, para evitar que cualquier cambio
    // quede en memoria
      try {
        return super.clone();
      } catch (CloneNotSupportedException e) {
        // TODO: handle exception
        return new Product(id, name, price);
      }
  }
}
