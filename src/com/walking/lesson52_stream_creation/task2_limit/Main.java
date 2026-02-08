package com.walking.lesson52_stream_creation.task2_limit;

import java.time.LocalDate;
import java.util.stream.Stream;

/**
 * Реализуйте программу, выводящую в консоль все даты текущего месяца.
 * Используйте Stream.limit()
 */
public class Main {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();

        Stream.iterate(1, i -> ++i)
                .limit(now.lengthOfMonth())
                .forEach(i -> System.out.printf("%d.%d.%d\n", i, now.getMonthValue(), now.getYear()));
    }
}
