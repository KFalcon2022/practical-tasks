package com.walking.lesson67_locks.task3.service;

import com.walking.lesson67_locks.task3.model.Counter;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CounterService {
    private final Counter counter;
    private final ReentrantReadWriteLock rwLock;
    private final Condition needToPrint;

    public CounterService(Counter counter) {
        this.counter = counter;
        rwLock = new ReentrantReadWriteLock();
        needToPrint = rwLock.writeLock().newCondition();
    }

    public void increaseToNumber(long limit) {
        boolean isFinished = false;
        try {
            while (true) {
                if (getValue() == limit) {
                    return;
                }
                rwLock.writeLock().lock();
                counter.increase(1);

                if (getValue() % 100 == 0) {
                    System.out.println("Value is: " + getValue());
                }
            }
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    private long getValue() {
        try {
            rwLock.readLock().lock();
            return counter.getValue();
        } finally {
            rwLock.readLock().unlock();
        }
    }
}
