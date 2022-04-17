package com.example.shoppingbasket.shoppingbasket.repository;

import com.example.shoppingbasket.shoppingbasket.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ProductRepository {

    List<Product> findAll();
    Optional<Product> findById(int id);

}
