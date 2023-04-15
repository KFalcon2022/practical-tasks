package com.walking.lesson62_wait_notify.task2.service;

import com.walking.lesson62_wait_notify.task2.model.WholesaleBase;

public class WholesaleBaseHolder {
    private final WholesaleBase wholesaleBase;

    public WholesaleBaseHolder(WholesaleBase wholesaleBase) {
        this.wholesaleBase = wholesaleBase;
    }

    public boolean isSupplyAvailable() {
        return getFillPercent() <= wholesaleBase.getMinProductAmountPercent();
    }

    public boolean isBuyAvailable() {
        return wholesaleBase.getProductAmount() > 0;
    }

    public double getFillPercent() {
        return (double) wholesaleBase.getProductAmount() / wholesaleBase.getMaxProductAmount();
    }

    //    Может быть использован, если при мониторинге необходимо выводить текущее количество доступных товаров
    public long getBalance() {
        return wholesaleBase.getProductAmount();
    }

    public boolean buy(long amount) {
        if (wholesaleBase.getProductAmount() < amount) {
            return false;
        }

        wholesaleBase.setProductAmount(wholesaleBase.getProductAmount() - amount);

        return true;
    }

    public long getSupplyAvailableAmount() {
        return wholesaleBase.getMaxProductAmount() - wholesaleBase.getProductAmount();
    }

    public void supply(long amount) {
        if (getSupplyAvailableAmount() < amount) {
            throw new RuntimeException("Supply: too much products");
        }

        wholesaleBase.setProductAmount(wholesaleBase.getProductAmount() + amount);
    }
}
