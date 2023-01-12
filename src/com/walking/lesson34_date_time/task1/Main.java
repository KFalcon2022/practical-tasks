package com.walking.lesson34_date_time.task1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Scanner;

/**
 * Реализуйте метод, возвращающий объект LocalDateTime на основании переданной строки.
 * Пример входящей строки: 20.12.2022 20:16:00.
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Spell the date in format dd.MM.yyyy HH:mm:ss");

        String dateTime = scanner.nextLine();
        scanner.close();

        LocalDateTime localDateTime = LocalDateTime.parse(dateTime, new DateTimeFormatterBuilder()
                .appendPattern("dd.MM.yyyy HH:mm:ss")
                .parseDefaulting(ChronoField.NANO_OF_SECOND, 0)
                .toFormatter());
    }
}
