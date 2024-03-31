package com.walking.lesson68_semaphore.task1.service;

import com.walking.lesson68_semaphore.task1.model.Philosopher;

import java.util.concurrent.Semaphore;

public class PhilosopherLunchCounter implements Runnable {
    private final Philosopher philosopher;
    private final Semaphore luchSemaphore;

    public PhilosopherLunchCounter(Philosopher philosopher, Semaphore luchSemaphore) {
        this.philosopher = philosopher;
        this.luchSemaphore = luchSemaphore;
    }

    @Override
    public void run() {
        while (philosopher.getLunchCounter() < 3) {
            try {
                luchSemaphore.acquireUninterruptibly();
                System.out.println(philosopher + " tries to get fork.");
                try {
                    philosopher.getLeftFork().lock();
                    System.out.println(philosopher + " get left fork.");
                    try {
                        philosopher.getRightFork().lock();
                        System.out.println(philosopher + " get right fork.");

                        philosopher.increaseLunchCounter();
                        System.out.println(philosopher + " has eaten " + philosopher.getLunchCounter() + " times.");
                    } finally {
                        philosopher.getRightFork().unlock();
                    }
                } finally {
                    philosopher.getLeftFork().unlock();
                }
            } finally {
                luchSemaphore.release();
            }
        }
    }
}
