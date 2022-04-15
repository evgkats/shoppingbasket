package com.example.shoppingbasket.shoppingbasket.repository;

import com.example.shoppingbasket.shoppingbasket.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ProductRepository {

    public List<Product> findAll();
    public Optional<Product> findById(int id);
}
