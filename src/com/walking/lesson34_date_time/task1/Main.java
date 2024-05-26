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
        System.out.println(parseTime("11.02.2011 16:16:16"));
        System.out.println(parseTime("22.12.2022 15:20:50"));
    }

    private static LocalDateTime parseTime(String s) {
        return LocalDateTime.parse(s, FORMATTER);
    }
}
