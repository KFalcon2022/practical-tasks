package com.walking.lesson52_stream_creation.task2_iterate;

import java.time.LocalDate;
import java.util.stream.Stream;

/**
 * Реализуйте программу, выводящую в консоль все даты текущего месяца.
 * Не используйте Stream.limit()
 */
public class Main {
    public static void main(String[] args) {
        LocalDate today=LocalDate.now().minusDays(LocalDate.now().getDayOfMonth()-1);
        Stream.iterate(today, date->date.plusDays(1))
        .takeWhile(date->date.getMonthValue()==LocalDate.now().getMonthValue())
        .forEach(date->System.out.println(date));
        
    }
}
