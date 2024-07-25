package com.walking.lesson67_locks.task3.model;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private volatile int x = 0;

    private final int maxValue;
    private final Lock lock = new ReentrantLock();

    public Lock getLock() {
        return lock;
    }

    public Counter(int maxValue) {
        this.maxValue = maxValue;
    }

    public void increase() {
        x++;
    }

    public boolean isExcess() {
        return x > maxValue;
    }

    public int getX() {
        return x;
    }
}
