package com.walking.lesson52_stream_creation.task2_iterate;

import java.time.LocalDate;
import java.util.stream.Stream;

/**
 * Реализуйте программу, выводящую в консоль все даты текущего месяца.
 * Не используйте Stream.limit()
 */
public class Main {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();

        Stream.iterate(1,
                        i -> i <= now.lengthOfMonth(),
                        i -> ++i)
                .forEach(i -> System.out.printf("%d.%d.%d\n", i, now.getMonthValue(), now.getYear()));
    }
}
