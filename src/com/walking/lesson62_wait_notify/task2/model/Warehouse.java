package com.walking.lesson62_wait_notify.task2.model;

public class Warehouse {
    private final int maxProductAmount = 100;
    private final int minCapacity = maxProductAmount / 4;

    private int currentProductAmount = 0;
    private boolean isReadyForSupply = true;

    public synchronized int supply(int deliveryQuantity) {
        while (!isReadyForSupply) {
            try {
                System.out.println("\nFULL STOCK");
                System.out.println("WAIT in thread " + Thread.currentThread().getName());
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if (currentProductAmount + deliveryQuantity > maxProductAmount) {
            int changedDeliveryQuantity = maxProductAmount - currentProductAmount;
            sendToWarehouse(changedDeliveryQuantity);

            int restOfDelivery = deliveryQuantity - changedDeliveryQuantity;
            System.out.printf(
                    "\nSupplier tried to deliver %d. But warehouse is full, rest of delivery is %d%n",
                    deliveryQuantity, restOfDelivery);
            return restOfDelivery;
        }
        sendToWarehouse(deliveryQuantity);
        return 0;
    }

    private synchronized void sendToWarehouse(int deliveryQuantity) {
        System.out.println("\nThread: " + Thread.currentThread().getName());
        System.out.println("Supplier try to delivery " + deliveryQuantity + " of goods.");

        currentProductAmount += deliveryQuantity;

        System.out.println("Warehouse balance is: " + currentProductAmount);

        if (currentProductAmount == maxProductAmount) {
            System.out.println("\nWarehouse if full - " + currentProductAmount + ". Stop delivery!");
            isReadyForSupply = false;
            notifyAll();
        }
    }

    public synchronized boolean buy(int purchaseQuantity) {
        while (currentProductAmount == 0) {
            try {
                System.out.println("\nNO GOODS");
                System.out.println("WAIT in thread " + Thread.currentThread().getName());
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if (purchaseQuantity > currentProductAmount) {
            return false;
        }

        System.out.println("\nThread: " + Thread.currentThread().getName());
        System.out.println("Buyer try to get " + purchaseQuantity + " of goods.");

        currentProductAmount -= purchaseQuantity;

        System.out.println("Warehouse balance is: " + currentProductAmount);

        if (currentProductAmount <= minCapacity && !isReadyForSupply) {
            System.out.println("\nWarehouse capacity is under 25% - " + currentProductAmount + ". Start delivery!");
            isReadyForSupply = true;
            notifyAll();
        }

        return true;
    }
}
