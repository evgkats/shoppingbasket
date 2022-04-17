package com.example.shoppingbasket.shoppingbasket.service;

import com.example.shoppingbasket.shoppingbasket.model.Order;
import com.example.shoppingbasket.shoppingbasket.web.dto.OrderDto;
import com.example.shoppingbasket.shoppingbasket.web.dto.OrderRequest;


public interface OrderService {

    Order createOrder(OrderRequest orderRequest);
    OrderDto createOrderDtoFromOrder(Order order);

}
