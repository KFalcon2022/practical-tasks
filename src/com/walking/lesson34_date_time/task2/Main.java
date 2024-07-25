package com.walking.lesson34_date_time.task2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Реализуйте программу, выводящую в консоль сообщение,
 * являются ли введенные с клавиатуры дата и время больше или меньше текущего.
 */
public class Main {
    public static final String FORMATTER_PATTERN = "dd.MM.yyyy HH:mm:ss";
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(FORMATTER_PATTERN);

    public static void main(String[] args) {
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("Текущее время: " + currentTime.format(FORMATTER));

        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите время и дату в формате: \"%s\" \n", FORMATTER_PATTERN);
        LocalDateTime localDateTime = LocalDateTime.parse(scanner.nextLine(), FORMATTER);

        if (localDateTime.isAfter(currentTime)) {
            System.out.println("Date is after now");
        } else if (localDateTime.isBefore(currentTime)) {
            System.out.println("Date is before now");
        } else {
            System.out.println("Date is equal");
        }
    }
}
