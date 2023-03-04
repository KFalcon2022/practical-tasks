package com.walking.lesson52_stream_creation.task2_limit;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

/**
 * Реализуйте программу, выводящую в консоль все даты текущего месяца.
 * Используйте Stream.limit()
 */
public class Main {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.now().withDayOfMonth(1);
        int monthDaysAmount = startDate.getMonth().length(startDate.isLeapYear());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        Stream.iterate(startDate.withDayOfMonth(1), date -> date.plusDays(1))
                .limit(monthDaysAmount)
                .map(date -> date.format(formatter))
                .forEach(System.out::println);
    }
}
