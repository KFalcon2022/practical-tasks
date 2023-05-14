package com.walking.lesson75_thread_pool.task2;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Реализуйте программу, которая сообщает о начале каждого часа.
 * Не используйте Thread.sleep() или циклы.
 */
public class Main {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public static void main(String[] args) {
        var from = ZonedDateTime.now()
                .plusHours(1)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);

        var initialDelay = Duration.between(ZonedDateTime.now(), from)
                .getSeconds();

        Executors.newSingleThreadScheduledExecutor()
                .scheduleAtFixedRate(
                        () -> System.out.println(getCurrentDateTimeFormatted()),
                        initialDelay, 60 * 60, TimeUnit.SECONDS);
    }

    private static String getCurrentDateTimeFormatted() {
        return LocalDateTime.now()
                .format(DATE_TIME_FORMATTER);
    }
}