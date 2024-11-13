package com.kaankacan.simple_crud_demo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class ProductCreateDTO {
    @NotEmpty(message = "Can not be empty!")
    @Size(min = 3, max = 20, message = "Must be between 3 and 20 characters!")
    private String name;
    @NotEmpty(message = "Can not be empty!")
    @Size(min = 3, max = 100,message = "Must be between 3 and 100 characters!")
    private String description;
    @Positive(message = "Must be grater than 0!")
    private double price;
    @PositiveOrZero(message = "Can not be negative!")
    private int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
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

    public ProductCreateDTO() {

    }

    public ProductCreateDTO(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }


}
