package com.walking.lesson34_date_time.task1;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Реализуйте метод, возвращающий объект LocalDateTime на основании переданной строки.
 * Пример входящей строки: 20.12.2022 20:16:00.
 */
public class Main {
    public static void main(String[] args) {
        String dateTime = "20.12.2022 20:16:00";

        System.out.println(parseDateTime(dateTime.split("\s"))
                .format(DateTimeFormatter.ofPattern("dd MMMM uuuuг. HH:mm:ss")));
    }

    private static LocalDateTime parseDateTime(String[] dataTime) {
        LocalDate requiredDate = parseDate(dataTime[0].split("\\."));
        LocalTime requierdTime = parseTime(dataTime[1].split(":"));
        return LocalDateTime.of(requiredDate, requierdTime);
    }

    private static LocalTime parseTime(@NotNull String[] time) {
        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        int seconds = Integer.parseInt(time[2]);
        return LocalTime.of(hours, minutes, seconds);
    }

    private static LocalDate parseDate(String[] date) {
        int dayOfMonth = Integer.parseInt(date[0]);
        int monthOfYear = Integer.parseInt(date[1]);
        int year = Integer.parseInt(date[2]);
        return LocalDate.of(year, monthOfYear, dayOfMonth);
    }
}
