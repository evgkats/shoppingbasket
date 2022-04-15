package com.example.shoppingbasket.shoppingbasket.service;

import com.example.shoppingbasket.shoppingbasket.model.Order;
import com.example.shoppingbasket.shoppingbasket.model.OrderProduct;
import com.example.shoppingbasket.shoppingbasket.repository.ProductRepository;
import com.example.shoppingbasket.shoppingbasket.web.dto.OrderDto;
import com.example.shoppingbasket.shoppingbasket.web.dto.OrderRequest;
import com.example.shoppingbasket.shoppingbasket.web.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final ProductRepository productRepository;

    public OrderServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Order createOrder(OrderRequest orderRequest) {
        Order order = new Order();

        order.setId(1);
        order.setOrderProducts(orderRequest.getProducts().stream()
                .map(p -> new OrderProduct(productRepository.findById(p.getId()).orElseThrow(), p.getQuantity()))
                .collect(Collectors.toList()));

        return order;
    }

    @Override
    public OrderDto createOrderDtoFromOrder(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(1);
        orderDto.setProducts(order.getOrderProducts().stream()
                .map(p -> new ProductDto(p.getProduct().getId(), p.getProduct().getName(), p.getProduct().getPrice(), p.getProduct().getShippingCost(), p.getTotal(), p.getShippingCost(), p.getQuantity()))
                .collect(Collectors.toList()));
        orderDto.setDiscounted(order.isEligibleForDiscount());
        orderDto.setTotalPrice(order.getTotalAfterDiscount());
        if (orderDto.isDiscounted())
            orderDto.setOriginalTotalPrice(order.getTotalOrderPrice());
        orderDto.setTotalShipping(order.getTotalShipping());
        orderDto.setTotal(orderDto.getTotalPrice().add(orderDto.getTotalShipping()));
        return orderDto;
    }

    @Override
    public String test() {
        return "hello test";
    }
}
