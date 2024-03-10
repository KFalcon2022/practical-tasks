package com.walking.lesson75_thread_pool.task4;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Stream;

/**
 * Реализуйте программу, которая выводит числа от 0 до 100 в консоль.
 * Выведения каждого десятка должно быть вынесено в отдельный поток,
 * в котором будут запущены потоки на выведение каждого конкретного числа.
 * <p>
 * Каждый конечный поток обязан спать в течении 500мс после того,
 * как выведет число в консоль.
 */
public class Main {
    public static void main(String[] args) {
        var threadPool = new ForkJoinPool();

        Stream.iterate(0, i -> i < 10, i -> ++i)
                .map(i -> getTask(i, threadPool))
                .forEach(ForkJoinTask::join);
    }

    private static ForkJoinTask<?> getTask(int decadeNumber, ForkJoinPool pool) {
        var startNumber = decadeNumber * 10 + 1;

        return pool.submit(() -> Stream.iterate(startNumber, i -> ++i)
                .limit(10)
//                Имя потока для наглядности
                .map(i -> (Runnable) () -> {
                    getPrintNumberTask(i);
                })
                .map(ForkJoinTask::adapt)
                .forEach(ForkJoinTask::fork));
    }

    private static void getPrintNumberTask(Integer i) {
        System.out.println(Thread.currentThread().getName() + ": " + i);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}