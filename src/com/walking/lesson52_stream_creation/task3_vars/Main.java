package com.walking.lesson52_stream_creation.task3_vars;

import java.time.LocalDate;
import java.time.Year;
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
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static void main(String[] args) {
        Year currentYear = Year.now();

        Stream<String> januaryDateStream = getDatesOfMonthString(1, currentYear);
        Stream<String> februaryDateStream = getDatesOfMonthString(2, currentYear);
        Stream<String> marchDateStream = getDatesOfMonthString(3, currentYear);
        Stream<String> aprilDateStream = getDatesOfMonthString(4, currentYear);
        Stream<String> mayDateStream = getDatesOfMonthString(5, currentYear);
        Stream<String> juneDateStream = getDatesOfMonthString(6, currentYear);
        Stream<String> julyDateStream = getDatesOfMonthString(7, currentYear);
        Stream<String> augustDateStream = getDatesOfMonthString(8, currentYear);
        Stream<String> septemberDateStream = getDatesOfMonthString(9, currentYear);
        Stream<String> octoberDateStream = getDatesOfMonthString(10, currentYear);
        Stream<String> novemberDateStream = getDatesOfMonthString(11, currentYear);
        Stream<String> decemberDateStream = getDatesOfMonthString(12, currentYear);

//        Выглядит забавно, но не стоит создавать вложенные concat() за пределами учебных задач.
//        Или хотя бы постарайтесь обернуть это красиво.
//        Используя дополнительные переменные или собственный рекурсивный/итеративный метод-обертку.
//        Но сначала убедитесь, что исходные стримы имеют различные источники и
//        не могут быть созданы через generate(), iterate() или другие методы-источники
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

    private static Stream<String> getDatesOfMonthString(int monthNumber, Year year) {
        LocalDate startDate = LocalDate.of(year.getValue(), monthNumber, 1);

        return Stream.iterate(startDate, date -> date.plusDays(1))
                .limit(year.atMonth(monthNumber).lengthOfMonth())
                .map(date -> date.format(FORMATTER));
    }
}
