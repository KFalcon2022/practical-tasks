package com.walking.lesson34_date_time.task3;

import java.time.Instant;
import java.time.LocalDate;
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

        System.out.println("Enter first date: ");
        String date1 = scanner.nextLine();
        date1 = "20.05.2022 01:16:00";
        System.out.println("Enter second date: ");
        String date2 = scanner.nextLine();
        date2 = "28.06.1932 02:51:56";
        scanner.close();

        if (date1.matches("\\d{2}\\.\\d{2}\\.\\d{4} \\d{2}:\\d{2}:\\d{2}") &&
                date2.matches("\\d{2}\\.\\d{2}\\.\\d{4} \\d{2}:\\d{2}:\\d{2}")) {
            compareDate(date1, date2);
        }

    }

    private static void compareDate(String date1, String date2) {
        LocalDateTime time1 = LocalDateTime.parse(date1, FORMATTER);
        LocalDateTime time2 = LocalDateTime.parse(date2, FORMATTER);

        if (time1.isAfter(time2)) {
            getDiffTime(time1, time2);
        }

        if (time2.isAfter(time1)) {
            getDiffTime(time2, time1);
        }
    }

    private static void getDiffTime(LocalDateTime timeAfter, LocalDateTime timeBefore) {
        long timeAfterSeconds = timeAfter.toEpochSecond(ZoneOffset.UTC);
        long timeBeforeSeconds = timeBefore.toEpochSecond(ZoneOffset.UTC);


        long seconds = Math.abs(timeAfterSeconds - timeBeforeSeconds);
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;

        long month = getAllDiffMonth(timeAfter, timeBefore);
        long year = getDiffYear(timeAfter, timeBefore);

        System.out.println("""
                Seconds: %d
                Minutes: %d
                Hours: %d
                Days: %d
                Months: %d
                Years: %d
                Summary: %d years, %d months, %d days, %d hours %d minutes %d seconds"""
                .formatted(
                        seconds,
                        minutes,
                        hours,
                        days,
                        month,
                        year,
                        year,
                        getDiffMonth(timeAfter, timeBefore),
                        getDiffDays(timeAfter, timeBefore),
                        getDiffHours(timeAfter, timeBefore),
                        getDiffMinute(timeAfter, timeBefore),
                        getDiffSecond(timeAfter, timeBefore)

                )
        );
    }

    private static long getDiffSecond(LocalDateTime timeAfter, LocalDateTime timeBefore) {
        if (isAfterSecond(timeAfter, timeBefore)) {
            return timeAfter.getSecond() - timeBefore.getSecond();
        }

        return timeAfter.getSecond() - timeBefore.getSecond() + 60;
    }

    private static long getDiffMinute(LocalDateTime timeAfter, LocalDateTime timeBefore) {
        int diff = 0;

        if (!isAfterSecond(timeAfter, timeBefore)) {
            diff = 1;
        }

        if (isAfterMinute(timeAfter, timeBefore)) {
            return timeAfter.getMinute() - timeBefore.getMinute() - diff;
        }

        return timeAfter.getMinute() - timeBefore.getMinute() + 60 - diff;
    }

    private static long getDiffHours(LocalDateTime timeAfter, LocalDateTime timeBefore) {
        int diff = 0;

        if (!isAfterMinute(timeAfter, timeBefore)) {
            diff = 1;
        }

        if (isAfterHour(timeAfter, timeBefore)) {
            return timeAfter.getHour() - timeBefore.getHour() - diff;
        }

        return timeAfter.getHour() - timeBefore.getHour() + 24 - diff;
    }

    private static long getDiffDays(LocalDateTime timeAfter, LocalDateTime timeBefore) {
        int diff = 0;

        if (!isAfterHour(timeAfter, timeBefore)) {
            diff = 1;
        }

        return timeAfter.minusDays(timeBefore.getDayOfMonth()).getDayOfMonth() - diff;
    }

    private static long getDiffMonth(LocalDateTime timeAfter, LocalDateTime timeBefore) {
        int diff = 0;

        if (!isAfterDayOfMonth(timeAfter, timeBefore)) {
            diff = 1;
        }

        if (timeAfter.getMonthValue() >= timeBefore.getMonthValue()) {
            return timeAfter.getMonthValue() - timeBefore.getMonthValue() - diff;
        }

        return timeAfter.getMonthValue() - timeBefore.getMonthValue() - diff + 12;
    }




    private static long getAllDiffMonth(LocalDateTime timeAfter, LocalDateTime timeBefore) {
        if (isAfterDayOfMonth(timeAfter, timeBefore)) {
            return (timeAfter.getYear() * 12L + timeAfter.getMonthValue()) - (timeBefore.getYear() * 12L + timeBefore.getMonthValue());
        }
        return (timeAfter.getYear() * 12L + timeAfter.getMonthValue()) - (timeBefore.getYear() * 12L + timeBefore.getMonthValue()) - 1;
    }


    private static long getDiffYear(LocalDateTime timeAfter, LocalDateTime timeBefore) {

        if (timeAfter.getDayOfYear() >= timeBefore.getDayOfYear() &&
                isAfterHour(timeAfter, timeBefore)
        ) {
            return timeAfter.getYear() - timeBefore.getYear();
        }

        return timeAfter.getYear() - timeBefore.getYear() - 1;
    }

    private static boolean isAfterSecond(LocalDateTime timeAfter, LocalDateTime timeBefore) {
        return timeAfter.getSecond() >= timeBefore.getSecond();
    }

    private static boolean isAfterMinute(LocalDateTime timeAfter, LocalDateTime timeBefore) {
        return timeAfter.getMinute() > timeBefore.getMinute() ||
                (timeAfter.getMinute() == timeBefore.getMinute() && isAfterSecond(timeAfter, timeBefore));
    }

    private static boolean isAfterHour(LocalDateTime timeAfter, LocalDateTime timeBefore) {
        return timeAfter.getHour() > timeBefore.getHour() ||
                (isAfterMinute(timeAfter, timeBefore) && timeAfter.getHour() == timeBefore.getHour());
    }

    private static boolean isAfterDayOfMonth(LocalDateTime timeAfter, LocalDateTime timeBefore) {
        return timeAfter.getDayOfMonth() >= timeBefore.getDayOfMonth() ||
                (isAfterHour(timeAfter, timeBefore) && timeAfter.getDayOfMonth() == timeBefore.getDayOfMonth());
    }
}

