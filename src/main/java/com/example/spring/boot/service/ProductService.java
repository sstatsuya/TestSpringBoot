package com.example.spring.boot.service;

import com.example.spring.boot.entity.Product;
import com.example.spring.boot.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(
            ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Get all products
    public ResponseEntity<List<Product>> fetchAllProducts()
    {
        return ResponseEntity.ok(productRepository.findAll());
    }
}

