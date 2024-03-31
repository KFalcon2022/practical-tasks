package com.walking.lesson68_semaphore.task1.model;

import java.util.concurrent.locks.Lock;

public class Philosopher {
    private final int id;
    private final Lock leftFork;
    private final Lock rightFork;

    private int lunchCounter;

    public Philosopher(int id, Lock leftFork, Lock rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public String toString() {
        return "Philosopher " + id;
    }

    public int getLunchCounter() {
        return lunchCounter;
    }

    public void increaseLunchCounter() {
        lunchCounter++;
    }

    public Lock getLeftFork() {
        return leftFork;
    }

    public Lock getRightFork() {
        return rightFork;
    }
}
