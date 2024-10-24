package com.kaankacan.simple_crud_demo.model;


import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    private String description;
    private double price;

    private int quantity;

    @Column(name = "sold_quantity")
    private int soldQuantity;

    public Product() {
    }

    public Product(String name,String description, double price, int quantity, int soldQuantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.soldQuantity = soldQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public String getDescription()
    {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }
}
