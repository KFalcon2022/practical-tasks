package com.walking.lesson52_stream_creation.task3_vars;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

/**
 * Реализуйте метод, возвращающий Stream<String> из дат месяца,
 * номер которого был передан параметром.
 * Выведите все даты года в консоль.
 * Избегайте дублирования кода.
 * Каждый Stream, возвращенный из метода, должен быть сохранен в отдельную переменную.
 */
public class Main {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static void main(String[] args) {
       Stream.iterate(1, i-> i <= 12, i -> ++i)
               .flatMap(Main::getDate)
               .forEach(System.out::println);

    }

    private static Stream<String> getDate(int month) {
        LocalDate dateMonth = LocalDate.now().withMonth(month).withDayOfMonth(1);
        int limit = dateMonth.lengthOfMonth();

        return Stream.iterate(dateMonth, i -> i.plusDays(1))
                .limit(limit)
                .map(d -> d.format(FORMATTER));
    }
}
