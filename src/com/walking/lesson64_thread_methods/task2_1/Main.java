package com.walking.lesson64_thread_methods.task2_1;

import com.walking.lesson64_thread_methods.task2_1.service.ArrayFillingService;
import com.walking.lesson64_thread_methods.task2_1.service.IntRandomGenerator;

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
    //    Решаем задачу с помощью потока-демона
    public static void main(String[] args) {
        initBackgroundThread();

        IntRandomGenerator randomGenerator = new IntRandomGenerator(1, 100);
        var arr = new ArrayFillingService(randomGenerator)
                .fill(new int[1000][100000]);
    }

    private static void initBackgroundThread() {
        var daemonThread = new Thread(() -> {
            while (true) {
                System.out.println(LocalDateTime.now());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        daemonThread.setDaemon(true);
        daemonThread.start();
    }
}