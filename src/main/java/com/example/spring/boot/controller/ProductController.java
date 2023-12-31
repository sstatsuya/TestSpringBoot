package com.example.spring.boot.controller;

import com.example.spring.boot.entity.Product;
import com.example.spring.boot.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    // Get all products
    @GetMapping("/products")
    public ResponseEntity<List<Product> > getAllProducts()
    {
        return productService.fetchAllProducts();
    }
}

