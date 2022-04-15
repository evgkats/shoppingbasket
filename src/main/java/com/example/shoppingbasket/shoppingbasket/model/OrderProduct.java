package com.example.shoppingbasket.shoppingbasket.model;

import java.math.BigDecimal;

public class OrderProduct {

    private Product product;
    private int quantity;

    public OrderProduct(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    public BigDecimal getShippingCost() {
        return product.getShippingCost().multiply(BigDecimal.valueOf(quantity));
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
