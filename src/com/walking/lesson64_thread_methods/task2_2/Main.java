package com.walking.lesson64_thread_methods.task2_2;

import com.walking.lesson64_thread_methods.task2_2.service.ArrayFillingService;
import com.walking.lesson64_thread_methods.task2_2.service.IntRandomGenerate;

import java.time.LocalDateTime;

/**
 * Напишите программу, заполняющую двумерный массив большого размера
 * (подберите на свой вкус, ограничения могут зависеть от заданного размера хипа в JVM)
 * случайными числами. Параллельно должен работать поток,
 * каждые 100 миллисекунд пишущий в консоль текущее время.
 * <p>
 * Программа должна завершиться, как только массив будет заполнен.
 * Предоставьте три различных решения данной программы. (Второе)
 */
public class Main {
    public static void main(String[] args) {
        var backgroundThread = initBackgroundThread();

        IntRandomGenerate intRandomGenerate = new IntRandomGenerate(1, 100);
        var arr = new ArrayFillingService(intRandomGenerate)
                .fill(new int[10000][10000]);

        backgroundThread.interrupt();
    }

    private static Thread initBackgroundThread() {
        var backgroundThread = new Thread(() -> {
            while (!Thread.interrupted()) {
                System.out.println(LocalDateTime.now());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    return;
                }
            }
        });

        backgroundThread.start();

        return backgroundThread;
    }
}