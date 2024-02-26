package com.walking.lesson64_thread_methods.task2_3;

import com.walking.lesson64_thread_methods.daemon.CurrentTimeService;
import com.walking.lesson64_thread_methods.service.ArrayService;
import com.walking.lesson64_thread_methods.service.IntRandomGenerator;

import java.time.LocalTime;

/**
 * Напишите программу, заполняющую двумерный массив большого размера
 * (подберите на свой вкус, ограничения могут зависеть от заданного размера хипа в JVM)
 * случайными числами. Параллельно должен работать поток,
 * каждые 100 миллисекунд пишущий в консоль текущее время.
 * <p>
 * Программа должна завершиться, как только массив будет заполнен.
 * Предоставьте три различных решения данной программы. (Первое)
 */
public class Main {
    public static void main(String[] args) {
        int[][] array = new int[700][100000];

        IntRandomGenerator intRandomGenerator = new IntRandomGenerator(0, 11);
        ArrayService arrayService = new ArrayService(array, intRandomGenerator);

        initBackgroundService(Thread.currentThread());
        arrayService.getFilledArray();
    }

    private static void initBackgroundService(Thread mainThread) {
        var backgroungThread = new Thread(() -> {
            while (mainThread.getState() != Thread.State.TERMINATED) {
                System.out.println(LocalTime.now());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    return;
                }
            }
        });

        backgroungThread.start();
    }
}