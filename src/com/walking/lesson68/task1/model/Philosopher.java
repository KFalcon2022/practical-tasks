package com.walking.lesson68.task1.model;

import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {
    private final Semaphore leftFork;
    private final Semaphore rightFork;

    int count = 0;

    public Philosopher(Semaphore left, Semaphore right) {
        this.leftFork = left;
        this.rightFork = right;
    }

    @Override
    public void run() {
        while (count < 3) {
            if (leftFork.tryAcquire()) {
                if (rightFork.tryAcquire()) {
                    count++;
                    leftFork.release();
                    rightFork.release();
                    System.out.printf("Philosopher %s ate %d time(s)%n", Thread.currentThread().getName(), count);
                } else {
                    leftFork.release();
                }
            }
        }
    }
}
