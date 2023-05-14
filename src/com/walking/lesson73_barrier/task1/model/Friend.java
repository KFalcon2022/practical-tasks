package com.walking.lesson73_barrier.task1.model;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Friend implements Runnable {
    private final int patience;
    private final int delay;
    private final CyclicBarrier barrier;

    public Friend(int patience, int delay, CyclicBarrier barrier) {
        this.patience = patience;
        this.delay = delay;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            // Обертка над Thread.sleep()
            TimeUnit.SECONDS.sleep(delay);

            barrier.await(patience, TimeUnit.SECONDS);
        } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
            Thread.currentThread().interrupt();
        }
    }

    public int getPatience() {
        return patience;
    }

    public int getDelay() {
        return delay;
    }

    public CyclicBarrier getBarrier() {
        return barrier;
    }
}
