package com.walking.lesson52_stream_creation.task3_flatMap;

import java.time.LocalDate;
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
        Stream.iterate(Integer.valueOf(1), i->i=i+1)
        .takeWhile(i->i!=13)
        .flatMap(i->dateOfMonth(i))
        .forEach(s->System.out.println(s));
    }

    public static Stream<String> dateOfMonth(int monthNumber){
        LocalDate today= LocalDate.of(LocalDate.now().getYear(), monthNumber, 1);
        return Stream.iterate(today, date->date.plusDays(1))
        .limit(today.lengthOfMonth())
        .map(LocalDate::toString);
    }
}
