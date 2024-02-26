package com.walking.lesson65_atomics.task2.service;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class EqualNumberCounter {
    private final LongAdder countResult;

    public EqualNumberCounter() {
        countResult = new LongAdder();
    }

    public long getEqualValueNumber(int[][] array, final int value) {
        Arrays.stream(array)
                .map(arr -> getMatchingTask(arr, value))
                .map(Thread::new)
                .peek(Thread::start)
                .forEach(this::joinThreadEx);

        return countResult.sumThenReset();
    }

    private Runnable getMatchingTask(int[] array, final int value) {
        return () -> {
            countResult.add(
                    Arrays.stream(array)
                            .filter(e -> e == value)
                            .count());
        };
    }

    private void joinThreadEx(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
