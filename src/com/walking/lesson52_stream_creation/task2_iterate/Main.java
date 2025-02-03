package com.walking.lesson52_stream_creation.task2_iterate;

import java.time.LocalDate;
import java.util.stream.Stream;

/**
 * Реализуйте программу, выводящую в консоль все даты текущего месяца.
 * Не используйте Stream.limit()
 */
public class Main {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();

        Stream.iterate(localDate.withDayOfMonth(1), d -> d.plusDays(1))
              .takeWhile(d -> d.getMonthValue() == localDate.getMonthValue())
              .forEach(System.out::println);

        Stream.iterate(1, i -> i < localDate.lengthOfMonth(), i -> ++i)
              .map(localDate::withDayOfMonth)
              .forEach(System.out::println);

        localDate.withDayOfMonth(1)
                 .datesUntil(localDate.withDayOfMonth(1)
                                      .plusMonths(1))
                 .forEach(System.out::println);
    }
}
