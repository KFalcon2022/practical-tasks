package com.walking.lesson34_date_time.task3;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static java.time.temporal.ChronoUnit.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first date and time:");
        String firstDate = scanner.nextLine();
        System.out.println("Enter second date and time:");
        String secondDate = scanner.nextLine();
        scanner.close();

        LocalDateTime firstDateTime = getDateTimeFromString(firstDate);
        LocalDateTime secondDateTime = getDateTimeFromString(secondDate);

        Period period = Period.between(firstDateTime.toLocalDate(), secondDateTime.toLocalDate());

        long seconds = Math.abs(firstDateTime.until(secondDateTime, SECONDS));

        long minutes = Math.abs(firstDateTime.until(secondDateTime, MINUTES));

        long hours = Math.abs(firstDateTime.until(secondDateTime, HOURS));

        long days = Math.abs(firstDateTime.until(secondDateTime, DAYS));

        long months = Math.abs(firstDateTime.until(secondDateTime, MONTHS));

        long years = Math.abs(firstDateTime.until(secondDateTime, YEARS));

        long monthsRemainder = months % 12;

        long daysRemainder = Math.abs(period.getDays());

        long hoursRemainder = hours % 24;

        long minutesRemainder = minutes % 60;

        long secondsRemainder = seconds % 60;

        System.out.printf("Seconds: %d\n" +
                           "Minutes: %d\n" +
                           "Hours: %d\n" +
                           "Days: %d\n" +
                           "Months: %d\n" +
                           "Years: %d\n" +
         "Summary: %d years, %d months, %d days, %d hours %d minutes %d seconds\n",
                seconds, minutes, hours, days, months, years,
                years, monthsRemainder, daysRemainder, hoursRemainder, minutesRemainder, secondsRemainder);
    }

    public static LocalDateTime getDateTimeFromString(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        LocalDateTime localDateTime = LocalDateTime.parse(date, dateTimeFormatter);

        return localDateTime;
    }
}