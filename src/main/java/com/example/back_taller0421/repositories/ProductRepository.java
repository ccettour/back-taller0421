package com.example.back_taller0421.repositories;

import com.example.back_taller0421.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
