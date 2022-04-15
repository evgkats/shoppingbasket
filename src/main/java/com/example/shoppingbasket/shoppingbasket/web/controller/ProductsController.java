package com.example.shoppingbasket.shoppingbasket.web.controller;

import com.example.shoppingbasket.shoppingbasket.model.Product;
import com.example.shoppingbasket.shoppingbasket.repository.ProductRepository;
import com.example.shoppingbasket.shoppingbasket.web.dto.ProductDto;
import com.example.shoppingbasket.shoppingbasket.web.dto.ProductLiteDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductsController {

    private final ProductRepository productRepository;

    public ProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<ProductLiteDto> getAllProducts() {
        return productRepository
                .findAll().stream()
                .map(p -> new ProductLiteDto(p.getId(), p.getName(), p.getPrice(), p.getShippingCost()))
                .collect(Collectors.toList());
    }
}
