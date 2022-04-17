package com.example.shoppingbasket.shoppingbasket.web.controller;

import com.example.shoppingbasket.shoppingbasket.model.Order;
import com.example.shoppingbasket.shoppingbasket.service.OrderService;
import com.example.shoppingbasket.shoppingbasket.web.dto.OrderDto;
import com.example.shoppingbasket.shoppingbasket.web.dto.OrderRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private Map<String, Order> orders = new HashMap<>();

    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public OrderDto getOrder(HttpSession httpSession) {
        String sessionId = httpSession.getId();
        if (orders.containsKey(sessionId)) {
            return orderService.createOrderDtoFromOrder(orders.get(sessionId));
        }
        return new OrderDto();
    }

    @PostMapping
    public OrderDto submitOrder(@RequestBody OrderRequest orderRequest,
                                HttpServletRequest request,
                                HttpSession httpSession) {
        String sessionId = httpSession.getId();
        System.out.println(sessionId);
        orderRequest.setCustomerId(sessionId);
        Order order = orderService.createOrder(orderRequest);
        orders.put(order.getId(), order);
        return orderService.createOrderDtoFromOrder(order);
    }
}
