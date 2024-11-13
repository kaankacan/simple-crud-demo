package com.kaankacan.simple_crud_demo.controller;


import com.kaankacan.simple_crud_demo.dto.ProductCreateDTO;
import com.kaankacan.simple_crud_demo.dto.ProductDetailDTO;
import com.kaankacan.simple_crud_demo.dto.ProductListDTO;
import com.kaankacan.simple_crud_demo.dto.ProductUpdateDTO;
import com.kaankacan.simple_crud_demo.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductDetailDTO createProduct(@RequestBody @Valid ProductCreateDTO productCreateDTO) {
        return productService.saveProduct(productCreateDTO);
    }

    @GetMapping
    public List<ProductListDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDetailDTO getProductById(@PathVariable int id) {
        return productService.findProductById(id);
    }

    @GetMapping("/search")
    public List<ProductDetailDTO> findProductByName(@RequestParam String name) {
        return productService.findProductByName(name);
    }

    @GetMapping("/search/keyword")
    public List<ProductDetailDTO> findByNameOrDescriptionContaining(@RequestParam String keyword) {
        return productService.findbyNameOrDescriptionContaining(keyword);
    }

    @GetMapping("/filter/quantity")
    public List<ProductDetailDTO> findProductsQuantityMoreThan(@RequestParam int quantity) {
        return productService.findProductsByQuantityGreaterThan(quantity);
    }

    @GetMapping("/top-sellers")
    public List<ProductDetailDTO> findBestSellers() {
        return productService.findProductsOrderBySoldQuantityDesc();
    }

    @PutMapping("/{id}")
    public ProductDetailDTO updateProductById(@PathVariable(name = "id", required = true) int id, @RequestBody @Valid ProductUpdateDTO productUpdateDTO) {
        return productService.updateProduct(id, productUpdateDTO);
    }

    @PutMapping("/{id}/quantity")
    public ProductDetailDTO updateProductQuantity(@PathVariable int id, @RequestParam int quantity) {
        return productService.updateProductQuantity(id, quantity);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable int id) {
        productService.deleteProductById(id);
    }

    @DeleteMapping("/all")
    public void deleteAllProducts() {
        productService.deleteAllProducts();
    }
}
