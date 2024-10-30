package com.kaankacan.simple_crud_demo.repository;

import com.kaankacan.simple_crud_demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByName(String name);

    @Query("Select p From Product p where p.name LIKE %:keyword% or p.description LIKE %:keyword%")
    List<Product> findbyNameOrDescriptionContainig(@Param("keyword") String keyword);

    @Query("SELECT p FROM Product p WHERE p.quantity > :quantity")
    List<Product> findProductsByQuantityGreaterThan(@Param("quantity") int quantity);

    List<Product> findAllByOrderBySoldQuantityDesc();

}
