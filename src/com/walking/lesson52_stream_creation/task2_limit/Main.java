package com.walking.lesson52_stream_creation.task2_limit;

import java.time.LocalDate;
import java.util.stream.Stream;

/**
 * Реализуйте программу, выводящую в консоль все даты текущего месяца.
 * Используйте Stream.limit()
 */
public class Main {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();

        Stream.iterate(localDate.withDayOfMonth(1), d -> d.plusDays(1))
              .limit(localDate.lengthOfMonth())
              .forEach(System.out::println);

        Stream.iterate(1, i -> ++i)
              .map(localDate::withDayOfMonth)
              .limit(localDate.lengthOfMonth())
              .forEach(System.out::println);
    }
}
