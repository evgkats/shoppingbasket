package com.example.shoppingbasket.shoppingbasket.web.dto;

import java.util.List;

public class OrderRequest {

    private String customerId;
    List<OrderProductDto> products;

    public OrderRequest() {
    }

    public OrderRequest(String customerId, List<OrderProductDto> products) {
        this.customerId = customerId;
        this.products = products;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<OrderProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<OrderProductDto> products) {
        this.products = products;
    }
}
