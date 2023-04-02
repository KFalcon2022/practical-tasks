package com.walking.lesson60_thread.task1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

/**
 * Напишите программу, которая пишет в консоль текущее время каждый две секунды,
 * пока программа запущена.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        new Thread(getTimeTrackerTask()).start();
    }

    private static Runnable getTimeTrackerTask() {
        return () -> {
            while (true) {
                System.out.println(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS)); //округляем до секунд

                try {
                    TimeUnit.SECONDS.sleep(2); // Удобная обертка над Thread.sleep()
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }
}