package com.walking.lesson52_stream_creation.task2_iterate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

/**
 * Реализуйте программу, выводящую в консоль все даты текущего месяца.
 * Не используйте Stream.limit()
 */
public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now().withDayOfMonth(1);
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd MM yyyy");

        Stream.iterate(date, d -> d.getMonthValue() == date.getMonthValue(), d -> d.plusDays(1))
                .forEach(d -> System.out.println(f.format(d)));
    }
}
