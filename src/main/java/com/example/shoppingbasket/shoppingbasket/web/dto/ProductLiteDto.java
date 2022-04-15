package com.example.shoppingbasket.shoppingbasket.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;

public class ProductLiteDto {

    private Integer id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal pricePerItem;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal shippingCostPerItem;

    public ProductLiteDto(Integer id, String name, BigDecimal pricePerItem, BigDecimal shippingCostPerItem) {
        this.id = id;
        this.name = name;
        this.pricePerItem = pricePerItem;
        this.shippingCostPerItem = shippingCostPerItem;
    }

    public ProductLiteDto() {
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
}
