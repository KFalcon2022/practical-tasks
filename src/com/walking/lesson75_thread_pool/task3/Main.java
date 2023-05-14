package com.walking.lesson75_thread_pool.task3;

import com.walking.lesson75_thread_pool.task3.service.IntRandomGenerator;
import com.walking.lesson75_thread_pool.task3.service.ThreadByChunkArrayFillingService;

/**
 * Реализуйте третий вариант Задачи 2 урока 60 с использованием пулов потоков.
 *
 * @see com.walking.lesson60_thread.task2.Main
 */
public class Main {
    public static void main(String[] args) {
        var randomGenerator = new IntRandomGenerator(1, 10);

        new ThreadByChunkArrayFillingService(randomGenerator).fill(new int[10][10000000]);
    }
}