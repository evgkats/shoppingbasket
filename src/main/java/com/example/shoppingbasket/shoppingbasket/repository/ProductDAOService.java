package com.example.shoppingbasket.shoppingbasket.repository;

import com.example.shoppingbasket.shoppingbasket.model.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductDAOService implements ProductRepository {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Pasta", BigDecimal.valueOf(0.8), 0.5f));
        products.add(new Product(2, "Rice", BigDecimal.valueOf(1.5), 0.6f));
        products.add(new Product(3, "Flour", BigDecimal.valueOf(1), 1f));
        products.add(new Product(4, "Bread", BigDecimal.valueOf(3), 0.5f));
        products.add(new Product(5, "Sugar", BigDecimal.valueOf(1), 1f));
        products.add(new Product(6, "Milk", BigDecimal.valueOf(1.2), 0.8f));
        products.add(new Product(7, "Yogurt", BigDecimal.valueOf(2.5), 0.3f));
        products.add(new Product(8, "Salt", BigDecimal.valueOf(1.6), 0.5f));
        products.add(new Product(9, "Pepper", BigDecimal.valueOf(2.2), 0.2f));
        products.add(new Product(10, "Butter", BigDecimal.valueOf(2.5), 0.4f));
        products.add(new Product(11, "Olive Oil", BigDecimal.valueOf(15), 1f));
    }

    public List<Product> findAll() {
        return products;
    }

    @Override
    public Optional<Product> findById(int id) {
        return products.stream().filter(p -> p.getId() == id).findAny();
    }
}
