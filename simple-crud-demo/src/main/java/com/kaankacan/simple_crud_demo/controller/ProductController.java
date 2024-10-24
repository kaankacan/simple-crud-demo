package com.kaankacan.simple_crud_demo.controller;


import com.kaankacan.simple_crud_demo.model.Product;
import com.kaankacan.simple_crud_demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // CREATE
    @PostMapping
    public void createProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @PostMapping("/bulk")
    public void createMultipleProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Asus Notebook", "A high-end gaming laptop", 1500.00, 5, 0));
        products.add(new Product("Iphone 16", "Latest model smartphone", 900.00, 10, 1));
        products.add(new Product("Ipad", "10-inch display tablet", 400.00, 7, 2));
        products.add(new Product("Apple Watch", "Fitness tracking smartwatch", 200.00, 15, 3));
        products.add(new Product("Headphones", "Noise-cancelling headphones", 150.00, 20, 5));
        products.add(new Product("Monitor", "27-inch 4K monitor", 350.00, 4, 1));
        products.add(new Product("Razer Keyboard", "Mechanical gaming keyboard", 120.00, 12, 0));

        productService.createMultipleProducts(products);
    }

    // READ
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable int id) {
        return productService.findProductByid(id);
    }

    @GetMapping("/findbyName")
    public List<Product> findProductByName(@RequestParam String name) {
        return productService.findProductByName(name);
    }

    @GetMapping("/searchNameDescription")
    public List<Product> findByNameOrDescriptionContaining(@RequestParam String keyword) {
        return productService.findbyNameOrDescriptionContainig(keyword);
    }

    @GetMapping("/stockMoreThan")
    public List<Product> findProductsQuantityMoreThan(@RequestParam int quantity) {
        return productService.findProductsByQuantityGreaterThan(quantity);
    }

    @GetMapping("/bestSellers")
    public List<Product> findBestSellers() {
        return productService.findProductsOrderBySoldQuantityDesc();
    }

    // UPDATE
    @PutMapping("/{id}")
    public void updateProductById(@PathVariable int id, @RequestBody Product product) {
        productService.updateProduct(id, product);
    }

    @PutMapping("/updateProductQuantity/{id}")
    public void updateProductQuantity(@PathVariable int id, @RequestParam int quantity) {
        productService.updateProductQuantity(id, quantity);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable int id) {
        productService.deleteProductById(id);
    }

    @DeleteMapping
    public void deleteAllProducts() {
        productService.deleteAllProducts();
    }
}
