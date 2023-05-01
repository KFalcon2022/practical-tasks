package com.walking.lesson67_locks.task3.model;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockingCounter {
    private final Lock lock = new ReentrantLock();
    private final int maxValue;

    private volatile int value;

    public LockingCounter(int maxValue) {
        this.maxValue = maxValue;
    }

    public Lock getLock() {
        return lock;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getMaxValue() {
        return maxValue;
    }
}
