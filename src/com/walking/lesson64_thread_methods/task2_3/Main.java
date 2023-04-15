package com.walking.lesson64_thread_methods.task2_3;

import com.walking.lesson64_thread_methods.task2_3.service.ArrayFillingService;
import com.walking.lesson64_thread_methods.task2_3.service.IntRandomGenerator;

import java.time.LocalDateTime;

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
    //    Решаем задачу с помощью отслеживания состояния основного потока выполнения
    public static void main(String[] args) {
        var currentThread = Thread.currentThread();
        initBackgroundThread(currentThread);

        IntRandomGenerator randomGenerator = new IntRandomGenerator(1, 100);
        var arr = new ArrayFillingService(randomGenerator)
                .fill(new int[1000][100000]);
    }

    private static void initBackgroundThread(Thread mainThread) {
        var backgroundThread = new Thread(() -> {
            while (mainThread.getState() != Thread.State.TERMINATED) {
                System.out.println(LocalDateTime.now());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        backgroundThread.start();
    }
}