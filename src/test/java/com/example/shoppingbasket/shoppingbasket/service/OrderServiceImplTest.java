package com.example.shoppingbasket.shoppingbasket.service;

import com.example.shoppingbasket.shoppingbasket.model.Order;
import com.example.shoppingbasket.shoppingbasket.model.Product;
import com.example.shoppingbasket.shoppingbasket.repository.ProductRepository;
import com.example.shoppingbasket.shoppingbasket.web.dto.OrderProductDto;
import com.example.shoppingbasket.shoppingbasket.web.dto.OrderRequest;
import com.example.shoppingbasket.shoppingbasket.web.dto.ProductDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@EnableAutoConfiguration
class OrderServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private OrderRequest orderRequest;

    @Mock
    private List<OrderProductDto> products;

    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    void createOrder() {
        when(orderRequest.getProducts()).thenReturn(List.of(new OrderProductDto(1, 1)));
        Product product = new Product(1, "test", BigDecimal.ONE, 0f);
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(product));
        Order order = orderService.createOrder(orderRequest);
        System.out.println(order);
        assertEquals(1, order.getOrderProducts().size());
        assertEquals(product.getId(), order.getOrderProducts().get(0).getProduct().getId());
    }
}