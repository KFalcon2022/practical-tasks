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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        Stream.iterate(startDate,
                        date -> date.isBefore(startDate.plusMonths(1)),
                        date -> date.plusDays(1))
                .map(date -> date.format(formatter))
                .forEach(System.out::println);

//        Вариант с использованием IntStream
//        int monthDaysAmount = startDate.getMonth().length(currentDate.isLeapYear());
//
//        IntStream.rangeClosed(1, monthDaysAmount)
//                .mapToObj(currentDate::withDayOfMonth)
//                .map(date -> date.format(formatter))
//                .forEach(System.out::println);
    }
}
