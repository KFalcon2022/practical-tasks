package com.walking.lesson34_date_time.task1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Реализуйте метод, возвращающий объект LocalDateTime на основании переданной строки.
 * Пример входящей строки: 20.12.2022 20:16:00.
 */
public class Main {
    public static final DateTimeFormatter DATE_TIME_PATTERN = DateTimeFormatter.ofPattern("dd.MM.yyy HH:mm:ss");

    public static void main(String[] args) {
        String testLocalDateTime = "20.12.2022 20:16:00";

        LocalDateTime result = parseLocalDateTime(testLocalDateTime);

        System.out.println(result.format(DATE_TIME_PATTERN));
    }

    public static LocalDateTime parseLocalDateTime(String localDateTimeCandidate) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        return LocalDateTime.parse(localDateTimeCandidate, pattern);
    }
}
