package com.walking.lesson64_thread_methods.service;

import java.util.Arrays;

public class ArrayService {
    private final int[][] array;
    private final IntRandomGenerator intRandomGenerator;

    public ArrayService(int[][] array, IntRandomGenerator intRandomGenerator) {
        this.array = array;
        this.intRandomGenerator = intRandomGenerator;
    }

    public void getFilledArray() {
        Arrays.stream(array)
                .map(this::getFillingTask)
                .map(Thread::new)
                .peek(Thread::start)
                .forEach(this::joinThreadEx);
    }

    private Runnable getFillingTask(int[] array) {
        return () -> {
            for (int i = 0; i < array.length; i++) {
                array[i] = intRandomGenerator.getNumber();
            }
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
