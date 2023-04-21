package com.walking.lesson68.task2.model;

public class Runn implements Runnable {

    private final Philosopher philosopher;

    public Runn(Philosopher philosopher) {
        this.philosopher = philosopher;
    }

    @Override
    public void run() {
        while (philosopher.count < 3) {
            if (philosopher.getLock().tryAcquire(2)) {
                if (philosopher.getRight().getLock().tryAcquire()) {
                    if (philosopher.getLeft().getLock().tryAcquire()){
                        philosopher.count++;
                        System.out.printf("Philosopher %s ate %d time(s)%n", Thread.currentThread().getName(), philosopher.count);
                        philosopher.getLeft().getLock().release();
                    }
                    philosopher.getRight().getLock().release();
                }
                philosopher.getLock().release(2);
            }
        }
    }
}
