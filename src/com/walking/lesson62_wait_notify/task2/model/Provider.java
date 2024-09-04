package com.walking.lesson62_wait_notify.task2.model;

import java.time.Duration;
import java.util.Random;
import java.util.function.IntSupplier;

public class Provider implements Runnable {
    private final Depot depot;
    private final IntSupplier intSupplier;
    private final Random random = new Random();

    public Provider(Depot depot, IntSupplier intSupplier) {
        this.depot = depot;
        this.intSupplier = intSupplier;
    }

    @Override
    public void run() {
        int surplus = 0;

        while (!Thread.currentThread()
                      .isInterrupted()) {
            try {
                while (surplus == 0) {
                    surplus = intSupplier.getAsInt();
                }

                Thread.sleep(Duration.ofSeconds(random.nextInt(1, 4)));

                surplus = depot.trySupply(surplus);
            } catch (InterruptedException e) {
                Thread.currentThread()
                      .interrupt();
            }
        }
    }
}
