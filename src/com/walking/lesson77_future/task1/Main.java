package com.walking.lesson77_future.task1;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

/**
 * Реализуйте Задачу 2 урока 73. Не используйте барьер.
 *
 * @see com.walking.lesson73_barrier.task2.Main
 */
public class Main {
    public static void main(String[] args) {
        var arr = new int[][][]{
                {{1, 2, 3}, {4}}, // 2
                {{5}, {6, 7}}, //1
                {{8, 9}, {10}}, //2
                {{}, {}},
                {}
        }; // всего 5 четных элементов

        var result = countEvens(arr);
        System.out.println("Found even elements: " + result);
    }

    private static long countEvens(int[][][] arr) {
        var counter = new AtomicLong();

        Arrays.stream(arr)
                .flatMap(Arrays::stream)
                .map(Main::getEvenCountTask)
                .map(task -> CompletableFuture.supplyAsync(task)
                        .thenAccept(counter::addAndGet))
                .toList()
                .forEach(CompletableFuture::join);

        return counter.get();
    }

// Альтернативное решение в чисто функциональном стиле, но с явным вызовом блокирующей операции.
//    private static long countEvensAlt(int[][][] arr) {
//        return Arrays.stream(arr)
//                .flatMap(Arrays::stream)
//                .map(Main::getEvenCountTask)
//                .map(CompletableFuture::supplyAsync)
//                .toList()
//                .stream()
//                .mapToLong(Main::getResultOrEx)
//                .sum();
//    }

    private static <T> T getResultOrEx(CompletableFuture<T> completableFuture) {
        try {
            return completableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private static Supplier<Long> getEvenCountTask(int[] arr) {
        return () -> Arrays.stream(arr)
                .filter(i -> i % 2 == 0)
                .count();
    }
}