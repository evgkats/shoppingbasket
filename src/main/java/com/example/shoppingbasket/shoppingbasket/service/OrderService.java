package com.example.shoppingbasket.shoppingbasket.service;

import com.example.shoppingbasket.shoppingbasket.model.Order;
import com.example.shoppingbasket.shoppingbasket.web.dto.OrderDto;
import com.example.shoppingbasket.shoppingbasket.web.dto.OrderRequest;


public interface OrderService {

    public Order createOrder(OrderRequest orderRequest);
    public OrderDto createOrderDtoFromOrder(Order order);
    public String test();

}
