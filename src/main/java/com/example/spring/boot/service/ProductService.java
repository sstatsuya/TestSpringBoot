package com.example.spring.boot.service;

import com.example.spring.boot.entity.Product;
import com.example.spring.boot.entity.ProductException;
import com.example.spring.boot.errorHandler.APIError;
import com.example.spring.boot.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(
            ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Get all products
    public ResponseEntity<List<Product>> fetchAllProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    // Get a product by ID
    public ResponseEntity<Optional<Product>>
    getProductById(Long id)  {
        Optional<Product> product
                = productRepository.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product);
        } else {
            throw new ProductException("Tim khong co san pham nay");
//            return ResponseEntity.notFound().build();
//            throw new APIError();
        }
    }
}

