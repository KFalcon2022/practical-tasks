package com.walking.lesson62_wait_notify.task2.model;

import java.util.Random;

public class Buyer implements Runnable {
    private final String name;
    private final Warehouse warehouse;
    private final Random random = new Random();
    private final int minPurchaseQuantity = 1;
    private final int maxPurchaseQuantity = 23;

    private int purchaseQuantity;

    public Buyer(Warehouse warehouse, String name) {
        this.name = name;
        this.warehouse = warehouse;
        setPurchaseQuantity();
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        boolean isPurchaseSuccessful;

        while (!Thread.interrupted()) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            isPurchaseSuccessful = warehouse.buy(purchaseQuantity);

            if (!isPurchaseSuccessful) {
                System.out.println("\nBuyer " + name + " can't buy " + purchaseQuantity + ". Trying less quantity");
                purchaseQuantity--;
            } else {
                System.out.println("\nBuyer " + name + " quantity is 0, refresh!");
                setPurchaseQuantity();
                System.out.println("Buyer " + name + " new quantity is " + purchaseQuantity);
            }
        }
    }

    private void setPurchaseQuantity() {
        purchaseQuantity = random.nextInt(minPurchaseQuantity, maxPurchaseQuantity);
    }
}
