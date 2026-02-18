package com.walking.lesson52_stream_creation.task3_vars;

import java.time.LocalDate;
import java.time.Month;
import java.util.stream.Stream;

/**
 * Реализуйте метод, возвращающий Stream<String> из дат месяца,
 * номер которого был передан параметром.
 * Выведите все даты года в консоль.
 * Избегайте дублирования кода.
 * Каждый Stream, возвращенный из метода, должен быть сохранен в отдельную переменную.
 */
public class Main {
    public static void main(String[] args) {
        Stream<String> jan = getDateStream(1);
        Stream<String> feb = getDateStream(2);
        Stream<String> march = getDateStream(3);
        Stream<String> april = getDateStream(4);
        Stream<String> may = getDateStream(5);
        Stream<String> june = getDateStream(6);
        Stream<String> july = getDateStream(7);
        Stream<String> aug = getDateStream(8);
        Stream<String> sep = getDateStream(9);
        Stream<String> oct = getDateStream(10);
        Stream<String> nov = getDateStream(11);
        Stream<String> dec = getDateStream(12);

        concatStreams(jan, feb, march, april, may, june, july, aug, sep, oct, nov, dec)
                .forEach(System.out::println);

    }

    public static Stream<String> getDateStream(int month) {
        LocalDate date = LocalDate.of(2026, month, 1);
        return Stream.iterate(date, d -> d.plusDays(1))
                .limit(Month.of(month).length(false))
                .map(LocalDate::toString);
    }

    public static Stream<String> concatStreams(Stream<String>... streams) {
        Stream<String> str = Stream.empty();
        for (Stream<String> s : streams) {
            str = Stream.concat(str, s);
        }
        return str;
    }
}
