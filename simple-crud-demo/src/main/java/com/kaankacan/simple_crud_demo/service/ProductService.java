package com.kaankacan.simple_crud_demo.service;

import com.kaankacan.simple_crud_demo.dto.ProductCreateDTO;
import com.kaankacan.simple_crud_demo.dto.ProductDetailDTO;
import com.kaankacan.simple_crud_demo.dto.ProductListDTO;
import com.kaankacan.simple_crud_demo.dto.ProductUpdateDTO;
import com.kaankacan.simple_crud_demo.model.Product;
import com.kaankacan.simple_crud_demo.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {

        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }


    public ProductDetailDTO saveProduct(ProductCreateDTO productCreateDTO) {

        Product savedProduct = productRepository.save(modelMapper.map(productCreateDTO, Product.class));
        return modelMapper.map(savedProduct, ProductDetailDTO.class);
    }

    public List<ProductListDTO> getAllProducts() {

        List<Product> getAllproductsList = productRepository.findAll();
        return getAllproductsList.stream()
            .map(product -> modelMapper.map(product, ProductListDTO.class))
            .collect(Collectors.toList());
    }

    public ProductDetailDTO findProductById(int id) {

        Product product = productRepository.findById(id).get();
        return modelMapper.map(product, ProductDetailDTO.class);
    }

    public List<ProductDetailDTO> findProductByName(String name) {

        List<Product> products = productRepository.findByName(name);

        return products.stream()
            .map(product -> modelMapper.map(product, ProductDetailDTO.class)).collect(Collectors.toList());
    }

    public List<ProductDetailDTO> findbyNameOrDescriptionContaining(String keyword) {

        List<Product> products = productRepository.findbyNameOrDescriptionContainig(keyword);
        return products.stream()
            .map(product -> modelMapper.map(product, ProductDetailDTO.class))
            .collect(Collectors.toList());
    }

    public List<ProductDetailDTO> findProductsByQuantityGreaterThan(int quantity) {

        List<Product> productList = productRepository.findProductsByQuantityGreaterThan(quantity);
        return productList.stream()
            .map(product -> modelMapper.map(product, ProductDetailDTO.class)).collect(Collectors.toList());
    }

    public List<ProductDetailDTO> findProductsOrderBySoldQuantityDesc() {

        List<Product> productList = productRepository.findAllByOrderBySoldQuantityDesc();
        return productList.stream()
            .map(product -> modelMapper.map(product, ProductDetailDTO.class))
            .collect(Collectors.toList());
    }

    public ProductDetailDTO updateProduct(int id, ProductUpdateDTO productUpdateDTO) {

        Product product = productRepository.findById(id).get();
        modelMapper.map(productUpdateDTO, product);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDetailDTO.class);

    }

    public ProductDetailDTO updateProductQuantity(int id, int quantity) {

        Optional<Product> existingProductop = productRepository.findById(id);
        Product existingProduct = existingProductop.get();
        existingProduct.setQuantity(quantity);
        Product product = productRepository.save(existingProduct);
        return modelMapper.map(product, ProductDetailDTO.class);
    }

    public void deleteProductById(int id) {
        productRepository.deleteById(id);
    }

    public void deleteAllProducts() {
        productRepository.deleteAll();
    }

}
