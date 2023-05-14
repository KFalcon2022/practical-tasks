package com.walking.lesson75_thread_pool.task3.service;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Stream;

public class ThreadByChunkArrayFillingService implements ArrayFillingService {
    private final int DEFAULT_CHUNK_SIZE = 10000;

    private final IntRandomGenerator randomGenerator;
    private final ForkJoinPool threadPool = new ForkJoinPool();

    public ThreadByChunkArrayFillingService(IntRandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    // Можно выделить собственный пул, можно использовать ForkJoinPool через Stream API.
    // Мы пойдем по первому пути. В зависимости от контекста пул может как создаваться каждый раз,
    // так и выделяться один на сервис (более частый сценарий).
    public int[][] fill(int[][] array) {
        Arrays.stream(array)
                .flatMap(intArray -> Stream.iterate(
                                0,
                                i -> i < intArray.length,
                                i -> i + DEFAULT_CHUNK_SIZE)
                        .map(i -> getFillingTask(intArray, i)))
                .map(threadPool::submit)
                .forEach(ForkJoinTask::join);

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
}
