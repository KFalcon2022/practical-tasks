package com.walking.lesson62_wait_notify.task2.model;

public class WholesaleBase {
    private final long maxProductAmount;
    private final double minProductAmountPercent;

    private long productAmount;

    public WholesaleBase(long maxProductAmount, double minProductAmountPercent) {
        this.maxProductAmount = maxProductAmount;
        this.minProductAmountPercent = minProductAmountPercent;
    }

    public long getMaxProductAmount() {
        return maxProductAmount;
    }

    public double getMinProductAmountPercent() {
        return minProductAmountPercent;
    }

    public long getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(long productAmount) {
        this.productAmount = productAmount;
    }
}
