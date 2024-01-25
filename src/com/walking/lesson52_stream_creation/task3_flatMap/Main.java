package com.walking.lesson52_stream_creation.task3_flatMap;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Реализуйте метод, возвращающий Stream<String> из дат месяца,
 * номер которого был передан параметром.
 * Выведите все даты года в консоль.
 * Избегайте дублирования кода.
 * В main() Stream должен быть лишь 1. Требует использования flatMap().
 */
public class Main {
    private static final int YEAR = 2024;
    public static void main(String[] args) {
        Stream.iterate(1,m->m<=12,m->++m)
                .flatMap(Main::getDatesStringByMonth)
                .forEach(System.out::println);
    }
    private static Stream<String> getDatesStringByMonth(int monthNumber){
        Month inputMonth = Month.of(monthNumber);
        LocalDate startDate = LocalDate.of(YEAR,inputMonth,1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return Stream.iterate(startDate,date->date.plusDays(1))
                .limit(startDate.getMonth().length(startDate.isLeapYear()))
                .map(date->date.format(formatter))
                .map(String::valueOf);
    }
}
