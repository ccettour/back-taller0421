package com.example.back_taller0421.controllers;

import com.example.back_taller0421.entities.Product;
import com.example.back_taller0421.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    @Autowired
    private ProductService service;
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(service.findAll());
    }
    @PatchMapping("/{id}/stock")
    public ResponseEntity<Product> adjustStock(@PathVariable Long id, @RequestBody Integer
            quantity) {
        return ResponseEntity.ok(service.updateStock(id, quantity));
    }
}