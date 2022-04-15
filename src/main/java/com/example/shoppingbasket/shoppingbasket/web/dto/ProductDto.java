package com.example.shoppingbasket.shoppingbasket.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;

public class ProductDto {

    private Integer id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal pricePerItem;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal shippingCostPerItem;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal totalPrice;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal totalShippingCost;
    private int quantity;

    public ProductDto(Integer id, String name, BigDecimal pricePerItem, BigDecimal shippingCostPerItem, BigDecimal totalPrice, BigDecimal totalShippingCost, int quantity) {
        this.id = id;
        this.name = name;
        this.pricePerItem = pricePerItem;
        this.shippingCostPerItem = shippingCostPerItem;
        this.totalPrice = totalPrice;
        this.totalShippingCost = totalShippingCost;
        this.quantity = quantity;
    }

    public ProductDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(BigDecimal pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    public BigDecimal getShippingCostPerItem() {
        return shippingCostPerItem;
    }

    public void setShippingCostPerItem(BigDecimal shippingCostPerItem) {
        this.shippingCostPerItem = shippingCostPerItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalShippingCost() {
        return totalShippingCost;
    }

    public void setTotalShippingCost(BigDecimal totalShippingCost) {
        this.totalShippingCost = totalShippingCost;
    }
}
