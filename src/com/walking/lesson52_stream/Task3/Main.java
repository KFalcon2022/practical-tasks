package com.walking.lesson52_stream.Task3;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //test of a month
        //Stream<String> february = getDaysOf(2);
        //february.forEach(System.out::println);

        IntStream.rangeClosed(1, 12)
                .boxed()
                .flatMap(Main::getDaysOf)
                .forEach(System.out::println);
    }

    public static Stream<String> getDaysOf(int month) {
        // get current date
        LocalDate date = (new Date()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = date.getYear();

        // create new date with given month
        date = LocalDate.of(year, month, 1);

        return IntStream.rangeClosed(1, date.lengthOfMonth())
                .mapToObj(d -> LocalDate.of(year, month, d).toString());
    }
}
