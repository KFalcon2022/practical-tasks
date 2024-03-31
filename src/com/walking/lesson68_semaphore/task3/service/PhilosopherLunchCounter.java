package com.walking.lesson68_semaphore.task3.service;

import com.walking.lesson68_semaphore.task3.model.Philosopher;

import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class PhilosopherLunchCounter implements Runnable {
    private final Philosopher philosopher;
    private final Map<Integer, ReentrantLock> forks;

    public PhilosopherLunchCounter(Philosopher philosopher, Map<Integer, ReentrantLock> forks) {
        this.philosopher = philosopher;
        this.forks = forks;
    }

    @Override
    public void run() {
        int minForkNumber = philosopher.getForkNumbers().first();
        int maxForkNumber = philosopher.getForkNumbers().last();

        while (philosopher.getLunchCounter() < 3) {
            try {
                forks.get(minForkNumber).lock();
                try {
                    forks.get(maxForkNumber).lock();

                    philosopher.increaseLunchCounter();
                    System.out.printf("\n%s has eaten %d times",
                            philosopher, philosopher.getLunchCounter());
                } finally {
                    forks.get(maxForkNumber).unlock();
                }
            } finally {
                forks.get(minForkNumber).unlock();
            }
        }
    }
}
