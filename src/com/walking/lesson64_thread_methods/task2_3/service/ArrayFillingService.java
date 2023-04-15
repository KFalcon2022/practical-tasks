package com.walking.lesson64_thread_methods.task2_3.service;

import java.util.Arrays;

public class ArrayFillingService {
    private final IntRandomGenerator randomGenerator;

    public ArrayFillingService(IntRandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public int[][] fill(int[][] array) {
        Arrays.stream(array)
                .map(this::getFillingTask)
                .map(Thread::new)
                .peek(Thread::start)
                .forEach(this::joinThreadNoEx);

        return array;
    }

    private Runnable getFillingTask(int[] array) {
        return () -> {
            for (int i = 0; i < array.length; i++) {
                array[i] = randomGenerator.generate();
            }
        };
    }

    private void joinThreadNoEx(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
