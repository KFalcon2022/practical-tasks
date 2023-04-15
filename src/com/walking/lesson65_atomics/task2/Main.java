package com.walking.lesson65_atomics.task2;

import java.util.Arrays;
import java.util.concurrent.atomic.LongAdder;

/**
 * Реализуйте метод, возвращающий число элементов равных N в двумерном массиве целых чисел.
 * Массив и N должны передаваться как параметры метода.
 * <p>
 * Каждый одномерный массив должен быть обработан в своем потоке.
 */
public class Main {
    public static void main(String[] args) {
        int[][] array = {
                {1, 5, 1, 6, 7},
                {2, 5, 1, 6, 8, 1},
                {1, 1, 1, 1, 1, 1}};

        System.out.println(getNumberCounter(1, array));
    }

    public static long getNumberCounter(int findingNumber, int[][] array) {
        return count(new LongAdder(), findingNumber, array).longValue();
    }

    public static LongAdder count(LongAdder counter, int findingNumber, int[][] array) {
        Arrays.stream(array)
                .map(arr -> getCountingTask(counter, findingNumber, arr))
                .map(Thread::new)
                .peek(Thread::start)
                .forEach(Main::joinThreadNoEx);

        return counter;
    }

    private static Runnable getCountingTask(LongAdder counter, int findingNumber, int[] array) {
        return () -> {
            var counted = Arrays.stream(array)
                    .filter(i -> i == findingNumber)
                    .count();

            counter.add(counted);
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