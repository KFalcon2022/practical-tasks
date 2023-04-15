package com.walking.lesson64_thread_methods.task2_2;

import com.walking.lesson64_thread_methods.task2_2.service.ArrayFillingService;
import com.walking.lesson64_thread_methods.task2_2.service.IntRandomGenerator;

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
    //    Решаем задачу с помощью прерывания потока
    public static void main(String[] args) {
        var backgroundThread = initBackgroundThread();

        IntRandomGenerator randomGenerator = new IntRandomGenerator(1, 100);
        var arr = new ArrayFillingService(randomGenerator)
                .fill(new int[1000][100000]);

        backgroundThread.interrupt();
    }

    private static Thread initBackgroundThread() {
        var backgroundThread = new Thread(() -> {
            while (!Thread.interrupted()) {
                System.out.println(LocalDateTime.now());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    return; //Если поток будет прерван, пока работает Thread.sleep() - мы попадем в эту секцию
                }
            }
        });

        backgroundThread.start();

        return backgroundThread;
    }
}