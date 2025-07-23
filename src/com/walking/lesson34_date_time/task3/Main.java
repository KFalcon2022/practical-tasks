package com.walking.lesson34_date_time.task3;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Реализуйте программу, выводящую в консоль количество времени между двумя
 * введенными с клавиатуры датами и временем в секундах, минутах, часах, днях, месяцах и годах.
 */
public class Main {
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.y HH:mm:ss");

    public static void main(String[] args) {
        System.out.print("Введите первую дату: ");
        Scanner in = new Scanner(System.in);
        String date1 = in.nextLine();
        System.out.print("Введите вторую дату: ");
        String date2 = in.nextLine();

        System.out.print(countTimeBetweenDates(getLocalDateTime(date1), getLocalDateTime(date2)));
    }

    public static String countTimeBetweenDates(LocalDateTime date1, LocalDateTime date2) {
        long seconds = Math.abs(date1.until(date2, ChronoUnit.SECONDS));
        long minutes = Math.abs(date1.until(date2, ChronoUnit.MINUTES));
        long hours = Math.abs(date1.until(date2, ChronoUnit.HOURS));
        long days = Math.abs(date1.until(date2, ChronoUnit.DAYS));
        long months = Math.abs(date1.until(date2, ChronoUnit.MONTHS));
        long years = Math.abs(date1.until(date2, ChronoUnit.YEARS));

        long finalMonth = months % 12;
        int finalDays;
        if (date1.isBefore(date2)) {
            finalDays = countDays(date1, date2);
        } else {
            finalDays = countDays(date2, date1);
        }
        long finalHours =  hours % 24;
        long finalMinutes =  minutes % 60;
        long finalSeconds = seconds % 60;

        return """
                Seconds: %d
                Minutes: %d
                Hours: %d
                Days: %d
                Months: %d
                Years: %d
                
                Summary: %d years, %d months, %d days, %d hours, %d minutes, %d seconds
                """.formatted(seconds, minutes, hours, days, months, years, years, finalMonth, finalDays, finalHours,
                finalMinutes, finalSeconds);
    }

    private static LocalDateTime getLocalDateTime(String dateTime) {
        try {
            return LocalDateTime.parse(dateTime, formatter);
        } catch (Exception e) {
            throw new RuntimeException("Дата указана некорректно.");
        }
    }

    private static int countDays(LocalDateTime dateBefore, LocalDateTime dateAfter) {
        int day1 = dateBefore.getDayOfMonth();
        int day2 = dateAfter.getDayOfMonth();

        if (day1 < day2) {
            return day2 - day1;
        } else {
            LocalDateTime date = dateAfter.minusMonths(1);
            Month month = date.getMonth();
            int daysInMonth = month.length(new GregorianCalendar().isLeapYear(date.getYear()));
            return daysInMonth - day1 + day2;
        }
    }
}
