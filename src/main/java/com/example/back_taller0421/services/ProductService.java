package com.example.back_taller0421.services;

import com.example.back_taller0421.entities.Product;
import com.example.back_taller0421.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product updateStock(Long id, Integer quantity) {
        Product product = repository.findById(id)
                .orElseThrow();

        if (product.getStock() < quantity) {
            throw new RuntimeException("Sin stock");
        }

        product.setStock(product.getStock() - quantity);
        return repository.save(product);
    }
}