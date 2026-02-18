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
        LocalDate date = LocalDate.now().withDayOfMonth(1);
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd MM yyyy");
        boolean leap = date.isLeapYear();

        Stream.iterate(date, d -> d.plusDays(1))
                .limit(date.getMonth().length(leap))
                .forEach(d -> System.out.println(f.format(d)));
    }
}
