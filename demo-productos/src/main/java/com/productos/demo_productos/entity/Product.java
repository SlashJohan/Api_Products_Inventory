package com.productos.demo_productos.entity;

import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private float price;

    private int antique;

    public Product() {}

    public Product(Long id, String name, float price, int antique) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.antique = antique;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getAntique() {
        return antique;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setAntique(int antique) {
        this.antique = antique;
    }
}
