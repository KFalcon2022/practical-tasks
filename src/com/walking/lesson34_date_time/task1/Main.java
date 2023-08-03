package com.walking.lesson34_date_time.task1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

/**
 * Реализуйте метод, возвращающий объект LocalDateTime на основании переданной строки.
 * Пример входящей строки: 20.12.2022 20:16:00.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(createLocalDate("20.12.2022 20:16:00"));
    }
    public static LocalDate createLocalDate(String stringDate) {

        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        return LocalDate.parse(stringDate,formatter);
    }
}
