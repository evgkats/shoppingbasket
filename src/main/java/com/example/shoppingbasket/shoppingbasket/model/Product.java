package com.example.shoppingbasket.shoppingbasket.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {

    private static final BigDecimal fixedShippingCost = BigDecimal.valueOf(5);

    private Integer id;
    private String name;
    private BigDecimal price;
    private Float weight;

    public Product(Integer id, String name, BigDecimal price, Float weight) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public BigDecimal getShippingCost() {
        return price.multiply(fixedShippingCost.multiply(new BigDecimal(Float.toString(weight)))).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getPrice() {
        return price.setScale(2, RoundingMode.HALF_UP);
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }
}
