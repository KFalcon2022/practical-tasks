package com.walking.lesson62_wait_notify.task2.model;

public class ProductBuyer {
    private final String name;

    private long productAmount;

    public ProductBuyer(String name) {
        this.name = name;
    }

    public long getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(long productAmount) {
        this.productAmount = productAmount;
    }

    public String getName() {
        return name;
    }
}
