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
        LocalDate startDate = LocalDate.now().withDayOfMonth(1);
        LocalDate endDate = LocalDate.now().plusMonths(1).withDayOfMonth(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        Stream.iterate(startDate,d->d.isBefore(endDate),d->d.plusDays(1))
                .map(d->d.format(formatter))
                .forEach(System.out::println);
    }
}
