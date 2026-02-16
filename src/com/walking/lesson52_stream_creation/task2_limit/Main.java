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

        Stream.iterate(date, d -> d.plusDays(1))
                .limit(date.getMonth().maxLength())
                .filter(d -> d.getMonthValue() == date.getMonthValue())
                .forEach(d -> System.out.println(f.format(d)));
    }
}
