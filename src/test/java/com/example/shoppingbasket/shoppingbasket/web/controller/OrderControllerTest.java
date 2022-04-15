package com.example.shoppingbasket.shoppingbasket.web.controller;

import com.example.shoppingbasket.shoppingbasket.model.Order;
import com.example.shoppingbasket.shoppingbasket.model.OrderProduct;
import com.example.shoppingbasket.shoppingbasket.model.Product;
import com.example.shoppingbasket.shoppingbasket.repository.ProductRepository;
import com.example.shoppingbasket.shoppingbasket.service.OrderService;
import com.example.shoppingbasket.shoppingbasket.web.dto.OrderDto;
import com.example.shoppingbasket.shoppingbasket.web.dto.OrderProductDto;
import com.example.shoppingbasket.shoppingbasket.web.dto.OrderRequest;
import com.example.shoppingbasket.shoppingbasket.web.dto.ProductDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrdersController.class)
@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    @MockBean
    private OrderService orderService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private Product product;

    @MockBean
    private ProductRepository productRepository;

    @Test
    void submitOrder() throws Exception {
//        when(product.getId()).thenReturn(anyInt());
        OrderProductDto orderProductDto = new OrderProductDto(product.getId(), 1);
        OrderRequest orderRequest = new OrderRequest("id", List.of(orderProductDto));
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(product));
        Order order = new Order(1, List.of(new OrderProduct(product, 1)));

        when(orderService.createOrder(orderRequest)).thenReturn(order);
        BigDecimal price = new BigDecimal("1.00");
        BigDecimal shipping = new BigDecimal("5.00");
        ProductDto productDto = new ProductDto(1, "test", price, shipping, price, shipping, 1);
        when(orderService.createOrderDtoFromOrder(order)).thenReturn(new OrderDto(1, List.of(productDto), price, false, price, shipping));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/orders")
                .content(objectMapper.writeValueAsString(orderRequest))
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andReturn();

        OrderDto orderDto = objectMapper.readValue(result.getResponse().getContentAsString(), OrderDto.class);
        assertEquals(1, orderDto.getProducts().size());
    }
}