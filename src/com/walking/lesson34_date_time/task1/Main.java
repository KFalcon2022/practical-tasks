package com.walking.lesson34_date_time.task1;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Реализуйте метод, возвращающий объект LocalDateTime на основании переданной строки.
 * Пример входящей строки: 20.12.2022 20:16:00.
 */
public class Main {
    public static void main(String[] args) {
        String input="20.12.2022 20:16:00";
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        LocalDate date=LocalDate.parse(input,formatter);
        LocalTime time=LocalTime.parse(input,formatter);
        LocalDateTime dateTime=LocalDateTime.of(date, time);
        System.out.println(dateTime.toString());
        System.out.println(date.getMonth());
        System.out.println(dateTime.format(formatter));
    }
}
