package com.walking.lesson34_date_time.task2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * Реализуйте программу, выводящую в консоль сообщение,
 * являются ли введенные с клавиатуры дата и время больше или меньше текущего.
 */
public class Main {
    public static final String FORMATTER_PATTERN = "dd.MM.yyyy HH:mm:ss";
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(FORMATTER_PATTERN);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a datetime: ");
        LocalDateTime date = LocalDateTime.parse(scanner.nextLine(), FORMATTER);

        scanner.close();

        LocalDateTime currentDate = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);

        if (date.isBefore(currentDate)) {
            System.out.println("date is before now");
        } else if (date.isAfter(currentDate)) {
            System.out.println("Date is after now");
        } else {
            System.out.println("date are equals");
        }
    }
}
