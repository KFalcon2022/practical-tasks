package com.walking.lesson34_date_time.task1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Реализуйте метод, возвращающий объект LocalDateTime на основании переданной строки.
 * Пример входящей строки: 20.12.2022 20:16:00.
 */
public class Main {
    public static final String FORMATTER_PATTERN = "dd.MM.yyyy HH:mm:ss";
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(FORMATTER_PATTERN);

    public static void main(String[] args) {
        System.out.println(parseDateTime("20.12.2022 20:12:00"));
        System.out.println(parseDateTime("20.12.2022 20:16:00"));
    }

    private static LocalDateTime parseDateTime (String date) {

        return LocalDateTime.parse(date, FORMATTER);
    }
}
