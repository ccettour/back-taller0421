package com.example.back_taller0421.controllers;

import com.example.back_taller0421.entities.Product;
import com.example.back_taller0421.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getAll() {
        return service.findAll();
    }

    @PatchMapping("/{id}/stock")
    public Product updateStock(@PathVariable Long id, @RequestBody Integer quantity) {
        return service.updateStock(id, quantity);
    }
}