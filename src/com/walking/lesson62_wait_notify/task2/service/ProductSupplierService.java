package com.walking.lesson62_wait_notify.task2.service;

import com.walking.lesson62_wait_notify.task2.model.ProductSupplier;

public class ProductSupplierService {
    private final IntRandomGenerator randomGenerator;
    private final WholesaleBaseHolder wholesaleBaseHolder;

    public ProductSupplierService(IntRandomGenerator randomGenerator, WholesaleBaseHolder wholesaleBaseHolder) {
        this.randomGenerator = randomGenerator;
        this.wholesaleBaseHolder = wholesaleBaseHolder;
    }

    public void supply(ProductSupplier productSupplier) throws InterruptedException {
        synchronized (wholesaleBaseHolder) {
            while (!wholesaleBaseHolder.isSupplyAvailable()) {
                wholesaleBaseHolder.wait();
            }

            trySupply(productSupplier);

            if (wholesaleBaseHolder.isBuyAvailable()) {
                wholesaleBaseHolder.notifyAll();
            }
        }
    }

    private void trySupply(ProductSupplier productSupplier) {
        var supplyingProductAmount =
                Math.min(productSupplier.getProductAmount(), wholesaleBaseHolder.getSupplyAvailableAmount());

        wholesaleBaseHolder.supply(supplyingProductAmount);

        System.out.printf("Supplier '%s' tryed to supply %d products. Supplied %d\n",
                productSupplier.getName(), productSupplier.getProductAmount(), supplyingProductAmount);

        var newSupplierProductAmount = supplyingProductAmount == productSupplier.getProductAmount()
                ? randomGenerator.generate()
                : productSupplier.getProductAmount() - supplyingProductAmount;
        productSupplier.setProductAmount(newSupplierProductAmount);
    }
}
