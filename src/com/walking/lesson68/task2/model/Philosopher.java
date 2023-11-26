package com.walking.lesson68.task2.model;

import java.util.concurrent.Semaphore;

public class Philosopher {

    private Semaphore lock = new Semaphore(2);
    private Philosopher left;
    private Philosopher right;

    private boolean isEating = false;
    int count = 0;

    public synchronized boolean isEating() {
        return isEating;
    }

    public synchronized void setEating(boolean eating) {
        isEating = eating;
    }

    public Philosopher getLeft() {
        return left;
    }

    public void setLeft(Philosopher left) {
        this.left = left;
    }

    public Philosopher getRight() {
        return right;
    }

    public void setRight(Philosopher right) {
        this.right = right;
    }

    public Semaphore getLock() {
        return lock;
    }
}
