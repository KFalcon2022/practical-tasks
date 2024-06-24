package com.walking.lesson65_atomics.task2.service;

import java.util.Arrays;

public class ArrayFillingService {
    private final IntRandomGenerate randomGenerate;

    public ArrayFillingService(IntRandomGenerate randomGenerate) {
        this.randomGenerate = randomGenerate;
    }

    public int[][] fill(int[][] array) {
        Arrays.stream(array)
                .map(this::getFillingTask)
                .map(Thread::new)
                .peek(Thread::start)
                .forEach(this::JoinThread);

        return array;
    }

    private Runnable getFillingTask(int[] array) {
        return () -> {
            for (int i = 0; i < array.length; i++) {
                array[i] = randomGenerate.generate();
            }
        };
    }

    private void JoinThread(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
