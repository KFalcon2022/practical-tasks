package com.walking.lesson67_locks.task3.model;

public class Counter {
    private long value;

    public void increase(int increment) {
        value += increment;
    }

    public long getValue() {
        return value;
    }
}
