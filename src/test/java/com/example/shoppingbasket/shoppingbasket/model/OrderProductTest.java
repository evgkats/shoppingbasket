package com.example.shoppingbasket.shoppingbasket.model;

import com.example.shoppingbasket.shoppingbasket.model.OrderProduct;
import com.example.shoppingbasket.shoppingbasket.model.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderProductTest {

    @Mock
    private Product product;
    private OrderProduct orderProduct;

    @Test
    void getTotal() {
        orderProduct = new OrderProduct(product, 5);
        BigDecimal expectedTotal = BigDecimal.valueOf(50); // 10(price) * 5(quantity) = 50
        when(product.getPrice()).thenReturn(BigDecimal.valueOf(10));
        BigDecimal actualTotal = orderProduct.getTotal();
        assertEquals(0, expectedTotal.compareTo(actualTotal),
                "The estimated total for the order should be " + expectedTotal);

        orderProduct.setQuantity(10);
        expectedTotal = BigDecimal.valueOf(100); // 10(price) * 10(quantity) = 100
        actualTotal = orderProduct.getTotal();
        assertEquals(0, expectedTotal.compareTo(actualTotal),
                "The estimated total for the order should be " + expectedTotal);
    }

    @Test
    void getShippingCost() {
        BigDecimal productPrice = BigDecimal.TEN;
        int productQuantity = 1;

        when(product.getShippingCost()).thenReturn(BigDecimal.valueOf(25)); // 10 * 5 * 0.5 = 5

        orderProduct = new OrderProduct(product, productQuantity);

        BigDecimal expectedShippingCost = BigDecimal.valueOf(25); // 10(price) * 5 (fixedAmount) * 0.5(weight) * 1 (quantity)
        BigDecimal actualShippingCost = orderProduct.getShippingCost();
        assertEquals(0, expectedShippingCost.compareTo(actualShippingCost),
                "Shipping cost for " + productQuantity + " products with price " + productPrice + " , should be " + expectedShippingCost);

        productQuantity = 10;
        orderProduct.setQuantity(productQuantity);
        expectedShippingCost = BigDecimal.valueOf(250); // 10(price) * 5 (fixedAmount) * 0.5(weight) * 10 (quantity)
        actualShippingCost = orderProduct.getShippingCost();
        assertEquals(expectedShippingCost.compareTo(actualShippingCost), 0,
                "Shipping cost for " + productQuantity + " products with price " + productPrice + " , should be " + expectedShippingCost);
    }
}