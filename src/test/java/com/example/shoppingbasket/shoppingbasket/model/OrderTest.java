package com.example.shoppingbasket.shoppingbasket.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class OrderTest {

    private Order order;

    @Mock
    private OrderProduct orderProduct1;
    @Mock
    private OrderProduct orderProduct2;

//    @BeforeEach
//    void setUp() {
//        when(orderProduct1.getTotal()).thenReturn(BigDecimal.valueOf(60));
//        when(orderProduct1.getShippingCost()).thenReturn(BigDecimal.valueOf(50));
//    }

    @Test
    void isEligibleForDiscount_whenOrderBelow100_thenReturnFalse() {
        when(orderProduct1.getTotal()).thenReturn(BigDecimal.valueOf(60));
        order = new Order("test", Collections.singletonList(orderProduct1));
        assertFalse(order.isEligibleForDiscount());
    }

    @Test
    void isEligibleForDiscount_whenOrderAbove100_thenReturnTrue() {
        when(orderProduct1.getTotal()).thenReturn(BigDecimal.valueOf(60));
        when(orderProduct2.getTotal()).thenReturn(BigDecimal.valueOf(70));
        order = new Order("test", List.of(orderProduct1, orderProduct2));
        assertTrue(order.isEligibleForDiscount());
    }

    @Test
    void getTotalOrderPrice_forOneItem() {
        when(orderProduct1.getTotal()).thenReturn(BigDecimal.valueOf(60));
        order = new Order("test", Collections.singletonList(orderProduct1));
        BigDecimal actualTotalPrice = order.getTotalOrderPrice();
        BigDecimal expectedTotalPrice = BigDecimal.valueOf(60); // 60 (price) * 1 (quantity) = 60
        assertEquals(0, actualTotalPrice.compareTo(expectedTotalPrice));
    }

    @Test
    void getTotalOrderPrice_forMultipleItems() {
        when(orderProduct1.getTotal()).thenReturn(BigDecimal.valueOf(60));
        when(orderProduct2.getTotal()).thenReturn(BigDecimal.valueOf(70));
        order = new Order("test", List.of(orderProduct1, orderProduct2));
        BigDecimal actualTotalPrice = order.getTotalOrderPrice();
        BigDecimal expectedTotalPrice = BigDecimal.valueOf(130); // 60 (price) * 1 (quantity) + 70 (price) * 1 (quantity) = 130
        assertEquals(0, actualTotalPrice.compareTo(expectedTotalPrice));
    }

    @Test
    void getTotalAfterDiscount_forOneItem() {
        when(orderProduct1.getTotal()).thenReturn(BigDecimal.valueOf(60));
        order = new Order("test", Collections.singletonList(orderProduct1));
        BigDecimal actualTotalPrice = order.getTotalAfterDiscount();
        BigDecimal expectedTotalPrice = BigDecimal.valueOf(60); // 60 (price) * 1 (quantity) = 60 (as price is below 100)
        assertEquals(0, actualTotalPrice.compareTo(expectedTotalPrice));
    }

    @Test
    void getTotalAfterDiscount_forMultipleItems() {
        when(orderProduct1.getTotal()).thenReturn(BigDecimal.valueOf(60));
        when(orderProduct2.getTotal()).thenReturn(BigDecimal.valueOf(70));
        order = new Order("test", List.of(orderProduct1, orderProduct2));
        BigDecimal actualTotalPrice = order.getTotalAfterDiscount();
        BigDecimal expectedTotalPrice = BigDecimal.valueOf(117); // 60 (price) * 1 (quantity) - (60*0.1)(discount) + 70 (price) * 1 (quantity) - (70*0.1)(discount) = 60 - 6  + 70 - 7 = 117
        assertEquals(0, actualTotalPrice.compareTo(expectedTotalPrice));
    }

    @Test
    void getTotalTotalShipping_forOneItem() {
        when(orderProduct1.getShippingCost()).thenReturn(BigDecimal.valueOf(50));
        order = new Order("test", Collections.singletonList(orderProduct1));
        BigDecimal actualTotalPrice = order.getTotalShipping();
        BigDecimal expectedTotalPrice = BigDecimal.valueOf(50); // 50 (shipping-cost) * 1 (quantity) = 50
        assertEquals(0, actualTotalPrice.compareTo(expectedTotalPrice));
    }

    @Test
    void getTotalTotalShipping_forMultipleItems() {
        when(orderProduct1.getShippingCost()).thenReturn(BigDecimal.valueOf(50));
        when(orderProduct2.getShippingCost()).thenReturn(BigDecimal.valueOf(70));
        order = new Order("test", List.of(orderProduct1, orderProduct2));
        BigDecimal actualTotalPrice = order.getTotalShipping();
        BigDecimal expectedTotalPrice = BigDecimal.valueOf(120); // 50 (shipping-cost) * 1 (quantity) + 70 (shipping-cost) * 1 (quantity) = 120
        assertEquals(0, actualTotalPrice.compareTo(expectedTotalPrice));
    }
}