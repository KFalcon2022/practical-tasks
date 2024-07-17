package com.walking.lesson60_thread.task2.model;

import java.util.Arrays;
import java.util.stream.Stream;

public class ThreadByChunkArrayFilling implements ArraysFill {
    private final int DEFAULT_CHUNK_SIZE = 500;

    private final IntRandomGenerate intRandomGenerate;

    public ThreadByChunkArrayFilling(IntRandomGenerate intRandomGenerate) {
        this.intRandomGenerate = intRandomGenerate;
    }

    @Override
    public int[][] fill(int[][] array) {
        Arrays.stream(array)
                .flatMap(intArray -> Stream.iterate(
                        0,
                        i -> i < intArray.length,
                        i -> i + DEFAULT_CHUNK_SIZE
                ).map(i -> getFillingTask(intArray, i)))
                .map(Thread::new)
                .peek(Thread::start)
                .forEach(this::joinThreadNoEx);

        return array;
    }

    private Runnable getFillingTask(int[] array, int iMin) {
        return () -> {
            int length = Math.min(array.length, iMin + DEFAULT_CHUNK_SIZE);

            for (int i = iMin; i < length; i++) {
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
