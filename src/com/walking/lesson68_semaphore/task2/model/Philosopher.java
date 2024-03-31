package com.walking.lesson68_semaphore.task2.model;

import java.util.concurrent.atomic.AtomicBoolean;

public class Philosopher {
    private final int id;
    private Philosopher leftPhilosopher;
    private Philosopher rightPhilosopher;

    private int lunchCounter;
    private AtomicBoolean isEating;

    public Philosopher(int id) {
        this.id = id;
        isEating = new AtomicBoolean(false);
    }

    public Philosopher (int id, Philosopher leftPhilosopher, Philosopher rightPhilosopher) {
        this(id);
        this.leftPhilosopher = leftPhilosopher;
        this.rightPhilosopher = rightPhilosopher;
    }

    @Override
    public String toString() {
        return "Philosopher " + id;
    }

    public Philosopher getLeftPhilosopher() {
        return leftPhilosopher;
    }

    public Philosopher getRightPhilosopher() {
        return rightPhilosopher;
    }

    public int getLunchCounter() {
        return lunchCounter;
    }

    public boolean isEating() {
        return isEating.get();
    }

    public void setIsEating(boolean newValue) {
        isEating.set(newValue);
    }

    public void increaseLunchCounter() {
        lunchCounter++;
    }

    public void setLeftPhilosopher(Philosopher leftPhilosopher) {
        if (this.leftPhilosopher == null) {
            this.leftPhilosopher = leftPhilosopher;
        }
    }

    public void setRightPhilosopher(Philosopher rightPhilosopher) {
        if (this.rightPhilosopher == null) {
            this.rightPhilosopher = rightPhilosopher;
        }
    }
}
