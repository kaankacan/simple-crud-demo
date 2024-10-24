package com.kaankacan.simple_crud_demo.service;

import com.kaankacan.simple_crud_demo.model.Product;
import com.kaankacan.simple_crud_demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    // CREATE
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public void createMultipleProducts(List<Product> products)
    {
        productRepository.saveAll(products);
    }

    // READ
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findProductByid(int id) {
        return productRepository.findById(id);
    }

    public List<Product> findProductByName(String name) {
        return productRepository.findByName(name);
    }

    public List<Product> findbyNameOrDescriptionContainig(String keyword) {
        return productRepository.findbyNameOrDescriptionContainig(keyword);
    }
    public List<Product> findProductsByQuantityGreaterThan(int quantity)
    {
        return productRepository.findProductsByQuantityGreaterThan(quantity);
    }
    public List<Product> findProductsOrderBySoldQuantityDesc()
    {
        return productRepository.findAllByOrderBySoldQuantityDesc();
    }
    // UPDATE
    public void updateProduct(int id, Product product) {
        Optional<Product> existingProductOpt = productRepository.findById(id);
        Product existingProduct = existingProductOpt.get();

        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(existingProduct.getQuantity());
        existingProduct.setSoldQuantity(existingProduct.getSoldQuantity());

        productRepository.save(existingProduct);
    }

    public void updateProductQuantity(int id, int quantity)
    {
        Optional<Product> existingProductop = productRepository.findById(id);
        Product existingProduct = existingProductop.get();
        existingProduct.setQuantity(quantity);
        productRepository.save(existingProduct);
    }

    // DELETE
    public void deleteProductById(int id) {
        productRepository.deleteById(id);
    }

    public void deleteAllProducts() {
        productRepository.deleteAll();
    }

}
