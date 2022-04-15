package com.example.shoppingbasket.shoppingbasket.model;

import com.example.shoppingbasket.shoppingbasket.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product(1, "test", BigDecimal.valueOf(5), 1f);
    }

    @Test
    void getShippingCost_simple() {
        BigDecimal expected = BigDecimal.valueOf(25); // 5 (price) * 5 (fixed) * 1 weight
        BigDecimal actual = product.getShippingCost();
        assertEquals(0, actual.compareTo(expected));
    }

    @Test
    void getShippingCost() {
        product.setWeight(0.25f);
        BigDecimal expected = BigDecimal.valueOf(6.25); // 5 (price) * 5 (fixed) * 0.25 weight
        BigDecimal actual = product.getShippingCost();
        assertEquals(0, actual.compareTo(expected));
    }
}