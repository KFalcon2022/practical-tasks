package com.walking.lesson34_date_time.task3;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Реализуйте программу, выводящую в консоль количество времени между двумя
 * введенными с клавиатуры датами и временем в секундах, минутах, часах, днях, месяцах и годах.
 */
public class Main {
    public static final String FORMATTER_PATTERN = "dd.MM.yyyy HH:mm:ss";
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(FORMATTER_PATTERN);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.println("Enter a first date: ");
//        LocalDateTime firstDate = LocalDateTime.parse(scanner.nextLine(), FORMATTER);
//
//        System.out.println("Enter a second date: ");
//        LocalDateTime secondDate = LocalDateTime.parse(scanner.nextLine(), FORMATTER);

        LocalDateTime date1 = LocalDateTime.of(2022, 12, 20, 20, 16);
        LocalDateTime date2 = LocalDateTime.of(1932, 6, 28, 2, 51, 56);

        scanner.close();

//        System.out.println(date1.minusSeconds(date2.getSecond()).getSecond());

        getTimeDifference(date1, date2);


//        long date1EpochDays = date1.toLocalDate().toEpochDay();
//        System.out.println(date1EpochDays);
//        long date2EpochDays = date2.toLocalDate().toEpochDay();
//        System.out.println(date2EpochDays);
//
//        long daysDifference = date1EpochDays - date2EpochDays;
//        System.out.println(daysDifference);
//
//        System.out.println(daysDifference);
    }

    private static void getTimeDifference(LocalDateTime date1, LocalDateTime date2) {
        long date1EpochSecond = date1.toEpochSecond(ZoneOffset.UTC);
//        System.out.println(date1EpochSecond);

        long date2EpochSecond = date2.toEpochSecond(ZoneOffset.UTC);
//        System.out.println(date2EpochSecond);

        long difference = date1EpochSecond - date2EpochSecond;
        System.out.println("Seconds: " + difference);
        difference /= 60;
        System.out.println("Minutes: " + difference);
        difference /= 60;
        System.out.println("Hours: " + difference);
        difference /= 24;
        System.out.println("Days: " + difference);

        long date1EpochDays = date1.toLocalDate().toEpochDay();
        System.out.println(date1EpochDays);
        long date2EpochDays = date2.toLocalDate().toEpochDay();
        System.out.println(date2EpochDays);
        long daysDifference = date1EpochDays - date2EpochDays;
        System.out.println(daysDifference);

    }
}
