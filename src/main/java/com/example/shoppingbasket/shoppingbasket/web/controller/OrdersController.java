package com.example.shoppingbasket.shoppingbasket.web.controller;

import com.example.shoppingbasket.shoppingbasket.model.Order;
import com.example.shoppingbasket.shoppingbasket.service.OrderService;
import com.example.shoppingbasket.shoppingbasket.web.dto.OrderDto;
import com.example.shoppingbasket.shoppingbasket.web.dto.OrderRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

//    @GetMapping("/{id}")
//    public Order getOrder(@PathVariable String id) {
//        return new Order();
//    }

    @GetMapping("/test")
    public String getOrder() {
        return orderService.test();
    }

    @PostMapping
    public OrderDto submitOrder(@RequestBody OrderRequest orderRequest) {
        Order order = orderService.createOrder(orderRequest);
        return orderService.createOrderDtoFromOrder(order);
    }
}
