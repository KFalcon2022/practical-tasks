package com.walking.lesson62_wait_notify.task2.model;

public class ProductSupplier {
    private final String name;

    private long productAmount;

    public ProductSupplier(String name) {
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
