package com.walking.lesson73_barrier.task2;

import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Реализуйте метод подсчета числа четных элементов в трехмерном массиве.
 * Распараллельте данный процесс.
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
        // Рассчитываем выделить по потоку на каждый одномерный массив
        var barrierParties = 0;

        for (int[][] arr0 : arr) {
            barrierParties += arr0.length;
        }

        var counter = new AtomicLong();
        var barrier = new CyclicBarrier(barrierParties);

        Arrays.stream(arr)
                .flatMap(Arrays::stream)
                .map(arr0 -> new Thread(getEvenCountTask(arr0, counter, barrier)))
                .peek(Thread::start)
                .toList()
                .forEach(Main::joinThreadNoEx);

        return counter.get();
    }

    private static Runnable getEvenCountTask(int[] arr, AtomicLong finalSum, CyclicBarrier barrier) {
        return () -> {
            try {
                var sum = Arrays.stream(arr)
                        .filter(i -> i % 2 == 0)
                        .count();
                finalSum.addAndGet(sum);

                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        };
    }

    private static void joinThreadNoEx(Thread thread) {
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}