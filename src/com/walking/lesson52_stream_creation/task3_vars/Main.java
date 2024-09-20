package com.walking.lesson52_stream_creation.task3_vars;

import java.time.LocalDate;
import java.util.LinkedList;
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
        LinkedList<Stream<String>> ll=new LinkedList<>();
        Stream.iterate(Integer.valueOf(1), i->i=i+1)
        .takeWhile(i->i!=13)
        .forEach(i->ll.add(dateOfMonth(i)));
        ll.stream().flatMap(stream->stream.map(String::toString)).forEach(s->System.out.println(s));
    }

    public static Stream<String> dateOfMonth(int monthNumber){
        LocalDate today= LocalDate.of(LocalDate.now().getYear(), monthNumber, 1);
        return Stream.iterate(today, date->date.plusDays(1))
        .limit(today.lengthOfMonth())
        .map(LocalDate::toString);
    }
}
