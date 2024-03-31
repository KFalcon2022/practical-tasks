package com.walking.lesson68_semaphore.task2.service;

import com.walking.lesson68_semaphore.task2.model.Philosopher;

public class PhilosopherLunchCounter implements Runnable {
    private final Philosopher philosopher;

    public PhilosopherLunchCounter(Philosopher philosopher) {
        this.philosopher = philosopher;
    }

    @Override
    public void run() {
        while (philosopher.getLunchCounter() < 3) {
            if (!philosopher.isEating()) {
                if (!philosopher.getLeftPhilosopher().isEating() && !philosopher.getRightPhilosopher().isEating()) {
                    philosopher.setIsEating(true);
                    philosopher.increaseLunchCounter();
                    System.out.println(philosopher + " has eaten " + philosopher.getLunchCounter() + " times.");
                    philosopher.setIsEating(false);
                }
            }
        }
    }
}
