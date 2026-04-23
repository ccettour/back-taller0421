package com.example.back_taller0421.services;

import com.example.back_taller0421.entities.Product;
import com.example.back_taller0421.exception.InsufficientStockException;
import com.example.back_taller0421.exception.ResourceNotFoundException;
import com.example.back_taller0421.repositories.ProductRepository;
import jakarta.transaction.Transactional;
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
    @Transactional
    public Product updateStock(Long id, Integer quantity) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));
        if (product.getStock() < quantity) {
            throw new InsufficientStockException("No hay stock suficiente");
        }
        product.setStock(product.getStock() - quantity);
        return repository.save(product);
    }}