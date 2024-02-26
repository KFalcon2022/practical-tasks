package com.walking.lesson62_wait_notify.task2.model;

import java.util.Random;

public class Supplier implements Runnable {
    private final String name;
    private final Random random = new Random();
    private final Warehouse warehouse;
    private final int minSupplyQuantity = 1;
    private final int maxSupplyQuantity = 45;

    private int supplyQuantity;

    public Supplier(Warehouse warehouse, String name) {
        this.name = name;
        this.warehouse = warehouse;
        setSupplyQuantity();
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        int restOfSupply;

        while (!Thread.interrupted()) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            restOfSupply = warehouse.supply(supplyQuantity);

            if (restOfSupply != 0) {
                supplyQuantity = restOfSupply;
            } else {
                System.out.println("\nSupplier " + name + " quantity is 0, refresh!");
                setSupplyQuantity();
                System.out.println("Supplier " + name + " new quantity is " + supplyQuantity);
            }
        }
    }

    public void setSupplyQuantity() {
        supplyQuantity = random.nextInt(minSupplyQuantity, maxSupplyQuantity);
    }
}
