package com.walking.lesson52_stream_creation.task3_flatMap;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Реализуйте метод, возвращающий Stream<String> из дат месяца,
 * номер которого был передан параметром.
 * Выведите все даты года в консоль.
 * Избегайте дублирования кода.
 * В main() Stream должен быть лишь 1. Требует использования flatMap().
 */
public class Main {
    public static void main(String[] args) {
        Stream.iterate(1, n -> n <= 12, n -> n + 1)
                .map(Main::getDateStream)
                .map(s -> s.collect(Collectors.toList()))
                .flatMap(List::stream)
                .forEach(System.out::println);
    }

    public static Stream<String> getDateStream(int month) {
        LocalDate date = LocalDate.of(2026, month, 1);
        return Stream.iterate(date, d -> d.plusDays(1))
                .limit(Month.of(month).length(false))
                .map(LocalDate::toString);
    }
}
