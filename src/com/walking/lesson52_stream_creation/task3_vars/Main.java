package com.walking.lesson52_stream_creation.task3_vars;

import java.time.LocalDate;
import java.time.Month;
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
    private static final int YEAR = 2024;
    public static void main(String[] args) {
        Stream<String> januaryDateStream = getDatesStringByMonth(1);
        Stream<String> februaryDateStream = getDatesStringByMonth(2);
        Stream<String> marchDateStream = getDatesStringByMonth(3);
        Stream<String> aprilDateStream = getDatesStringByMonth(4);
        Stream<String> mayDateStream = getDatesStringByMonth(5);
        Stream<String> juneDateStream = getDatesStringByMonth(6);
        Stream<String> julyDateStream = getDatesStringByMonth(7);
        Stream<String> augustDateStream = getDatesStringByMonth(8);
        Stream<String> septemberDateStream = getDatesStringByMonth(9);
        Stream<String> octoberDateStream = getDatesStringByMonth(10);
        Stream<String> novemberDateStream = getDatesStringByMonth(11);
        Stream<String> decemberDateStream = getDatesStringByMonth(12);

        Stream.concat(januaryDateStream,
                        Stream.concat(februaryDateStream,
                                Stream.concat(marchDateStream,
                                        Stream.concat(aprilDateStream,
                                                Stream.concat(mayDateStream,
                                                        Stream.concat(juneDateStream,
                                                                Stream.concat(julyDateStream,
                                                                        Stream.concat(augustDateStream,
                                                                                Stream.concat(septemberDateStream,
                                                                                        Stream.concat(octoberDateStream,
                                                                                                Stream.concat(novemberDateStream, decemberDateStream)))))))))))
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
