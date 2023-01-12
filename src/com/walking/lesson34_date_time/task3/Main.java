package com.walking.lesson34_date_time.task3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Scanner;

/**
 * Реализуйте программу, выводящую в консоль количество времени между двумя
 * введенными с клавиатуры датами и временем в секундах, минутах, часах, днях, месяцах и годах.
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Spell the date in format dd.MM.yyyy HH:mm:ss");

        String dateTime1 = scanner.nextLine();
        String dateTime2 = scanner.nextLine();
        DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder()
                .appendPattern("dd.MM.yyyy HH:mm:ss")
                .parseDefaulting(ChronoField.NANO_OF_SECOND, 0)
                .toFormatter();

        LocalDateTime localDateTime1 = LocalDateTime.parse(dateTime1, dateTimeFormatter);
        LocalDateTime localDateTime2 = LocalDateTime.parse(dateTime2, dateTimeFormatter);

    }
}
