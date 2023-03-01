package com.walking.lesson52_stream.Task2;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        LocalDate date = (new Date()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year = date.getYear();
        int month = date.getMonthValue();

        // v1
        IntStream.iterate(1, i -> i + 1)
                .limit(date.lengthOfMonth())
                .forEach(d -> System.out.printf("%04d-%02d-%02d\n", year, month, d));

        // v2
        IntStream.rangeClosed(1, date.lengthOfMonth())
                .forEach(d -> System.out.printf("%04d-%02d-%02d\n", year, month, d));
    }
}
