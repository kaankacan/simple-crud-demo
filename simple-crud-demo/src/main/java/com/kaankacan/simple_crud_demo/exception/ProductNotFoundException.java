package com.kaankacan.simple_crud_demo.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException (String message)
    {
        super(message);
    }
}
