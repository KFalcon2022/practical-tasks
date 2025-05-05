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
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATTER_PATTERN);
    public static final Scanner sc = new Scanner(System.in);

    public static final LocalDateTime firstDateTime = getDate();
    public static final LocalDateTime secondDateTime = getDate();


    public static void main(String[] args) {
        System.out.println(printTimeBetweenDates());

    }

    public static LocalDateTime getDate() {
        System.out.println("Enter a datetime: ");
        return LocalDateTime.parse(sc.nextLine(), formatter);
    }

    public static Long getSeconds() {
        long firstDateTimeInSeconds = firstDateTime.toEpochSecond(ZoneOffset.UTC);
        long secondDateTimeInSeconds = secondDateTime.toEpochSecond(ZoneOffset.UTC);

        return firstDateTimeInSeconds - secondDateTimeInSeconds;
    }

    public static Long getMinutes() {
        return getSeconds() / 60;
    }

    public static Long getHours() {
        return getMinutes() / 60;
    }

    public static Long getFullDays() {
        return getHours() / 24;
    }

    public static Long getMonths() {
        long monthDifference = 12L * (secondDateTime.getYear() - firstDateTime.getYear()) + secondDateTime.getMonthValue() - firstDateTime.getMonthValue();
        int dayDifference = secondDateTime.getDayOfMonth() - firstDateTime.getDayOfMonth();

        if (monthDifference > 0 && dayDifference < 0) {
            monthDifference--;
        } else if (monthDifference < 0 && dayDifference > 0) {
            monthDifference++;
        }

        return Math.abs(monthDifference);
    }

    public static int getYears() {
        return Math.abs(secondDateTime.getYear() - firstDateTime.getYear());
    }

    public static int getDays() {
        return 0;
    }

    public static String printTimeBetweenDates() {
        return """
                Seconds: %d
                Minutes: %d
                Hours: %d
                Days: %d
                Months: %d
                Years: %d
                Summary: %d years %d months %d days %d hours %d minutes %d seconds
                """.formatted(
                getSeconds(),
                getMinutes(),
                getHours(),
                getFullDays(),
                getMonths(),
                getYears(),
                getMonths() / 12,
                getMonths() % 12,
                getDays(), //TODO
                getHours() % 24,
                getMinutes() % 60,
                getSeconds() % 60);

    }
}

