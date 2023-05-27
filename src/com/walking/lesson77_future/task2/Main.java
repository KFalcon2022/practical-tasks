package com.walking.lesson77_future.task2;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Реализуйте параллельный поиск максимального значения в массиве чисел.
 */
public class Main {
    private static final int DEFAULT_CHUNK_SIZE = 500;

    public static void main(String[] args) {
        var arr = new int[100000];
        fillArray(arr);

        var maxValue = findMax(arr);
        System.out.printf("Max value: %d", maxValue);
    }

    private static void fillArray(int[] arr) {
        var random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1, 1000);
        }
    }

    private static int findMax(int[] array) {
        return Stream.iterate(0, i -> i < array.length, i -> i + DEFAULT_CHUNK_SIZE)
                .map(i -> getFindMaxTask(array, i))
                .map(CompletableFuture::supplyAsync)
                .toList()
                .stream()
                .mapToInt(Main::getResultOrEx)
                .max()
                .orElseThrow();
    }

    private static Supplier<Integer> getFindMaxTask(int[] array, int startIndex) {
        int endExclusiveIndex = Math.min(array.length, startIndex + DEFAULT_CHUNK_SIZE);

        return () -> Arrays.stream(array, startIndex, endExclusiveIndex)
                .max()
                .orElseThrow();
    }

    private static <T> T getResultOrEx(CompletableFuture<T> completableFuture) {
        try {
            return completableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}