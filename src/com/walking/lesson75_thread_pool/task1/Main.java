package com.walking.lesson75_thread_pool.task1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Реализуйте программу, которая выводит актуальное время каждую минуту,
 * начиная с текущего момента.
 * Не используйте Thread.sleep() или циклы.
 */
public class Main {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public static void main(String[] args) {
        Executors.newSingleThreadScheduledExecutor()
                .scheduleAtFixedRate(
                        () -> System.out.println(getCurrentDateTimeFormatted()),
                        0, 1, TimeUnit.MINUTES);
    }

    private static String getCurrentDateTimeFormatted() {
        return LocalDateTime.now()
                .format(DATE_TIME_FORMATTER);
    }
}