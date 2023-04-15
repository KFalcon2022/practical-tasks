package com.walking.lesson62_wait_notify.task2.service;

import com.walking.lesson62_wait_notify.task2.model.ProductBuyer;

public class ProductBuyerService {
    private final IntRandomGenerator randomGenerator;
    private final WholesaleBaseHolder wholesaleBaseHolder;

    public ProductBuyerService(IntRandomGenerator randomGenerator, WholesaleBaseHolder wholesaleBaseHolder) {
        this.randomGenerator = randomGenerator;
        this.wholesaleBaseHolder = wholesaleBaseHolder;
    }

    public void buy(ProductBuyer productBuyer) throws InterruptedException {
        synchronized (wholesaleBaseHolder) {
            while (!wholesaleBaseHolder.isBuyAvailable()) {
                wholesaleBaseHolder.wait();
            }

            tryBuy(productBuyer);

            if (wholesaleBaseHolder.isSupplyAvailable()) {
                wholesaleBaseHolder.notifyAll();
            }
        }
    }

    private void tryBuy(ProductBuyer productBuyer) {
        var success = wholesaleBaseHolder.buy(productBuyer.getProductAmount());

        var newBuyerProductAmount = success ? randomGenerator.generate() : productBuyer.getProductAmount() - 1;

        System.out.printf("Buyer '%s' tryed to buy %d products. Result: %s\n",
                productBuyer.getName(), productBuyer.getProductAmount(), success);

        productBuyer.setProductAmount(newBuyerProductAmount);
    }
}
