package com.walking.lesson52_stream_creation.task3_flatMap;

import java.time.LocalDate;
import java.util.stream.IntStream;
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
        IntStream.rangeClosed(1, 12)
                 .boxed()
                 .flatMap(Main::getDatesOfMonth)
                 .forEach(System.out::println);
    }

    public static Stream<String> getDatesOfMonth(int monthValue) {
        if (monthValue < 1 || monthValue > 12) {
            return Stream.empty();
        }

        LocalDate startOfCurrentMonth = LocalDate.now()
                                                 .withMonth(monthValue)
                                                 .withDayOfMonth(1);

        return Stream.iterate(startOfCurrentMonth, d -> d.plusDays(1))
                     .limit(startOfCurrentMonth.lengthOfMonth())
                     .map(LocalDate::toString);
    }
}
