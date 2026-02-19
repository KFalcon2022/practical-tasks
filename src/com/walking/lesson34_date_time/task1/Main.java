package com.walking.lesson34_date_time.task1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Реализуйте метод, возвращающий объект LocalDateTime на основании переданной строки.
 * Пример входящей строки: 20.12.2022 20:16:00.
 */
public class Main {

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    public static void main(String[] args) {
        String dateTime = "20.12.2022 20:16:00";

        System.out.println(parseDateTime(dateTime));
    }

    private static LocalDateTime parseDateTime(String dataTime) {
        return LocalDateTime.parse(dataTime, FORMATTER);
    }
}
