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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите дату согласно формату: " + FORMATTER_PATTERN);
        String date = scanner.nextLine();
        scanner.close();

        if (date.matches("\\d{2}\\.\\d{2}\\.\\d{4} \\d{2}:\\d{2}:\\d{2}")) {
            compareDateOfNow(date);
        }
    }

    private static void compareDateOfNow(String date) {
        LocalDateTime nowTime = LocalDateTime.now();

        LocalDateTime time = LocalDateTime.parse(date, FORMATTER);

        if (time.isAfter(nowTime)) {
            System.out.println("Введенная дата позже нынешней");
        }

        if (time.isBefore(nowTime)) {
            System.out.println("Введенная дата раньше нынешней");
        }

        if (time.isEqual(nowTime)) {
            System.out.println("Введенная дата равна нынешней");
        }


    }
}
