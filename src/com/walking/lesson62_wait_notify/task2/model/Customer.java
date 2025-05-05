package com.walking.lesson62_wait_notify.task2.model;

import java.time.Duration;
import java.util.Random;
import java.util.function.IntSupplier;

public class Customer implements Runnable {
    private final Depot depot;
    private final IntSupplier intSupplier;
    private final Random random = new Random();

    public Customer(Depot depot, IntSupplier intSupplier) {
        this.depot = depot;
        this.intSupplier = intSupplier;
    }

    @Override
    public void run() {
        int shortage = 1;

        while (!Thread.currentThread()
                      .isInterrupted()) {
            try {
                Thread.sleep(Duration.ofSeconds(random.nextInt(1, 4)));

                while (--shortage < 1) {
                    shortage = intSupplier.getAsInt();
                }

                shortage = depot.tryPurchase(shortage);
            } catch (InterruptedException e) {
                Thread.currentThread()
                      .interrupt();
            }
        }
    }
}
