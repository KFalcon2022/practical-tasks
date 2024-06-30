package com.walking.lesson65_atomics.task2.service;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class ArraySearchingService {
    private final int[][] array;
    private final AtomicInteger atomicInteger;

    public ArraySearchingService(int[][] array) {
        this.array = array;
        this.atomicInteger = new AtomicInteger();
    }

    public AtomicInteger search(int n) {
        Arrays.stream(array)
                .map(arr -> getCountingTask(arr, n))
                .map(Thread::new)
                .peek(Thread::start)
                .forEach(this::joinThread);

        return atomicInteger;
    }

    private Runnable getCountingTask(int[] array, int n) {
        return () -> {
            for (int j : array) {
                if (j == n) {
                    atomicInteger.incrementAndGet();
                }
            }
        };
    }

    private void joinThread(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
