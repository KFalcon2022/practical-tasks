package com.walking.lesson64_thread_methods.task2_2.service;

import java.util.Arrays;

public class ArrayFillingService {
    private final IntRandomGenerate intRandomGenerate;

    public ArrayFillingService(IntRandomGenerate intRandomGenerate) {
        this.intRandomGenerate = intRandomGenerate;
    }

    public int[][] fill(int[][] array) {
        Arrays.stream(array)
                .map(this::getFillingTask)
                .map(Thread::new)
                .peek(Thread::start)
                .forEach(this::joinThread);

        return array;
    }

    private Runnable getFillingTask(int[] array) {
        return () -> {
            for (int i = 0; i < array.length; i++) {
                array[i] = intRandomGenerate.generate();
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
