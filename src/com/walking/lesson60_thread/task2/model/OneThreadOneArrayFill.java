package com.walking.lesson60_thread.task2.model;

import java.util.Arrays;

public class OneThreadOneArrayFill implements ArraysFill {
    private final IntRandomGenerate intRandomGenerate;

    public OneThreadOneArrayFill(IntRandomGenerate intRandomGenerate) {
        this.intRandomGenerate = intRandomGenerate;
    }


    @Override
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
                array[i] = intRandomGenerate.generate();
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
