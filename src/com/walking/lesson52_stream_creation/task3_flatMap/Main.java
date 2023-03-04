package com.walking.lesson52_stream_creation.task3_flatMap;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

/**
 * Реализуйте метод, возвращающий Stream<String> из дат месяца,
 * номер которого был передан параметром.
 * Выведите все даты года в консоль.
 * Избегайте дублирования кода.
 * В main() Stream должен быть лишь 1. Требует использования flatMap().
 */
public class Main {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static void main(String[] args) {
        Year currentYear = Year.now();

        Stream.iterate(1, i -> i <= 12, i -> ++i)
                .flatMap(i -> getDatesOfMonthString(i, currentYear))
                .forEach(System.out::println);
    }

    private static Stream<String> getDatesOfMonthString(int monthNumber, Year year) {
        LocalDate startDate = LocalDate.of(year.getValue(), monthNumber, 1);

        return Stream.iterate(startDate, date -> date.plusDays(1))
                .limit(year.atMonth(monthNumber).lengthOfMonth())
                .map(date -> date.format(FORMATTER));
    }
}
