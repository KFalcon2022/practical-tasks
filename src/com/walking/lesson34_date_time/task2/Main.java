package com.walking.lesson34_date_time.task2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Scanner;

/**
 * Реализуйте программу, выводящую в консоль сообщение,
 * являются ли введенные с клавиатуры дата и время больше или меньше текущего.
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Spell the date in format dd.MM.yyyy HH:mm:ss");

        String dateTime = scanner.nextLine();

        LocalDateTime parsed = LocalDateTime.parse(dateTime, new DateTimeFormatterBuilder()
                .appendPattern("dd.MM.yyyy HH:mm:ss")
                .parseDefaulting(ChronoField.NANO_OF_SECOND, 0)
                .toFormatter());

        LocalDateTime now = LocalDateTime.now();

        if (parsed.isAfter(now)) {
            System.out.println("Введенное время больше текущего");
        } else {
            System.out.println("Введенное время меньше текущего");
        }

        scanner.close();
    }
}
