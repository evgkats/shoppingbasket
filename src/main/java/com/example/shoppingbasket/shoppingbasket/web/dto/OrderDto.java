package com.example.shoppingbasket.shoppingbasket.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderDto {
    private String id;
    private List<ProductDto> products;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal totalPrice;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal originalTotalPrice;
    private boolean isDiscounted;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal totalShipping;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal total;

    public OrderDto() {
        this.id = "";
        this.products = new ArrayList<>();
    }

    public OrderDto(String id, List<ProductDto> products, BigDecimal totalPrice, boolean isDiscounted, BigDecimal totalShipping, BigDecimal total) {
        this.id = id;
        this.products = products;
        this.totalPrice = totalPrice;
        this.isDiscounted = isDiscounted;
        this.totalShipping = totalShipping;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isDiscounted() {
        return isDiscounted;
    }

    public void setDiscounted(boolean discounted) {
        isDiscounted = discounted;
    }

    public BigDecimal getTotalShipping() {
        return totalShipping;
    }

    public void setTotalShipping(BigDecimal totalShipping) {
        this.totalShipping = totalShipping;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getOriginalTotalPrice() {
        return originalTotalPrice;
    }

    public void setOriginalTotalPrice(BigDecimal originalTotalPrice) {
        this.originalTotalPrice = originalTotalPrice;
    }
}
