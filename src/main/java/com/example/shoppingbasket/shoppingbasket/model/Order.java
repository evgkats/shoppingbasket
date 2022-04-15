package com.example.shoppingbasket.shoppingbasket.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private static final float DISCOUNT = 0.1f;
    private static final BigDecimal DISCOUNT_AFTER_AMOUNT = BigDecimal.valueOf(100);

    private Integer id;
    private List<OrderProduct> orderProducts = new ArrayList<>();

    public Order() {
    }

    public Order(Integer id, List<OrderProduct> orderProducts) {
        this.id = id;
        this.orderProducts = orderProducts;
    }

    public BigDecimal getTotalOrderPrice() {
        return orderProducts.stream()
                .map(OrderProduct::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal getTotalOrderPriceAfterDiscount() {
        BigDecimal totalOrderPrice = getTotalOrderPrice();
        return totalOrderPrice.subtract(new BigDecimal(Float.toString(DISCOUNT)).multiply(totalOrderPrice)).setScale(2, RoundingMode.HALF_UP);
    }

    public boolean isEligibleForDiscount() {
        return getTotalOrderPrice().compareTo(DISCOUNT_AFTER_AMOUNT) > 0;
    }

    public BigDecimal getTotalAfterDiscount() {
        return isEligibleForDiscount() ? getTotalOrderPriceAfterDiscount() : getTotalOrderPrice();
    }

    public BigDecimal getTotalShipping() {
        return orderProducts.stream()
                .map(OrderProduct::getShippingCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderProducts=" + orderProducts +
                '}';
    }
}
