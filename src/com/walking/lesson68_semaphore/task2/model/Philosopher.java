package com.walking.lesson68_semaphore.task2.model;

import java.util.concurrent.atomic.AtomicBoolean;

public class Philosopher {
    private final Integer number;
    private final AtomicBoolean eating;
    private final AtomicBoolean leftForkOccupied;
    private final AtomicBoolean rightForkOccupied;

    private int eatenCounter;

    public Philosopher(Integer number, AtomicBoolean leftForkOccupied, AtomicBoolean rightForkOccupied) {
        this.number = number;
        this.eating = new AtomicBoolean();
        this.leftForkOccupied = leftForkOccupied;
        this.rightForkOccupied = rightForkOccupied;
    }

    public Integer getNumber() {
        return number;
    }

    public AtomicBoolean getEating() {
        return eating;
    }

    public AtomicBoolean getLeftForkOccupied() {
        return leftForkOccupied;
    }

    public AtomicBoolean getRightForkOccupied() {
        return rightForkOccupied;
    }

    public int getEatenCounter() {
        return eatenCounter;
    }

    public void setEatenCounter(int eatenCounter) {
        this.eatenCounter = eatenCounter;
    }
}
