package com.walking.lesson60_thread.task2.service;

import java.util.Arrays;
import java.util.stream.Stream;

public class ThreadByChunkArrayFillingService implements ArrayFillingService {
    //    Примем размер секции, заполняемой одним потоком равной 500 элементам.
//    На каждые 500 элементов будет выделяться отдельный поток.
//    Оптимальный размер секции (chunk'а) для каждого процессора свой.
    private final int DEFAULT_CHUNK_SIZE = 10000;

    private final IntRandomGenerator randomGenerator;

    public ThreadByChunkArrayFillingService(IntRandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public int[][] fill(int[][] array) {
        Arrays.stream(array)
                .flatMap(intArray -> Stream.iterate(
                                0,
                                i -> i < intArray.length,
                                i -> i + DEFAULT_CHUNK_SIZE)
                        .map(i -> getFillingTask(intArray, i)))
                .map(Thread::new)
                .peek(Thread::start)
                .forEach(this::joinThreadNoEx);

        return array;
    }

    private Runnable getFillingTask(int[] array, int iMin) {
        return () -> {
            int length = Math.min(array.length, iMin + DEFAULT_CHUNK_SIZE);

            for (int i = iMin; i < length; i++) {
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
