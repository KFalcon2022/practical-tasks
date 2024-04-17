package com.walking.lesson34_date_time.task1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Реализуйте метод, возвращающий объект LocalDateTime на основании переданной строки.
 * Пример входящей строки: 20.12.2022 20:16:00.
 */
public class Main {
    public final static String FORMAT = "dd.MM.yyyy HH:mm:ss";
    public final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(FORMAT);

    public static void main(String[] args) {
        System.out.println(getTime("20.12.2022 20:16:00"));
    }

    private static LocalDateTime getTime(String timeString) {
        return LocalDateTime.parse(timeString, FORMATTER);
    }
}
