package com.walking.lesson34_date_time.task1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Реализуйте метод, возвращающий объект LocalDateTime на основании переданной строки.
 * Пример входящей строки: 20.12.2022 20:16:00.
 */
public class Main {
    public static final String FORMATTER_PATTERN = "dd.MM.yyyy HH:mm:ss";
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(FORMATTER_PATTERN);
    public static void main(String[] args) {
        System.out.println(parseDate("20.12.2022 20:16:00"));
        System.out.println(parseDate("20.06.2002 20:24:44"));
    }
    private static LocalDateTime parseDate(String date){
        return LocalDateTime.parse(date,FORMATTER);
    }
}
