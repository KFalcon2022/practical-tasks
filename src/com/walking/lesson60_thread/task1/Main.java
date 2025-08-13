package com.walking.lesson60_thread.task1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

/**
 * Напишите программу, которая пишет в консоль текущее время каждый две секунды,
 * пока программа запущена.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Duration twoSeconds = Duration.of(2, ChronoUnit.SECONDS);

        DateTimeFormatter mediumTimeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);

        Thread timePrinter = new Thread(printTimeCyclical(twoSeconds, mediumTimeFormatter), "timePrinter");

        timePrinter.start();
    }

    public static Runnable printTimeCyclical(Duration duration, DateTimeFormatter formatter) {
        return () -> {
            while (!Thread.currentThread()
                          .isInterrupted()) {
                System.out.println(LocalDateTime.now()
                                                .format(formatter));

                try {
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    Thread.currentThread()
                          .interrupt();
                }
            }
        };
    }
}