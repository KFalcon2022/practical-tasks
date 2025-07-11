package com.walking.lesson34_date_time.task2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Реализуйте программу, выводящую в консоль сообщение,
 * являются ли введенные с клавиатуры дата и время больше или меньше текущего.
 */
public class Main {
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.y HH:mm");

    public static void main(String[] args) {
        System.out.print("Введите дату: ");
        Scanner in = new Scanner(System.in);
        String date = in.nextLine();

        LocalDateTime dateTime = getLocalDateTime(date);
        compareDateTime(dateTime);
    }

    public static void compareDateTime(LocalDateTime dateTime) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        if (currentDateTime.isAfter(dateTime)) {
            System.out.println("Указанная дата была раньше текущей.");
        } else if (currentDateTime.isBefore(dateTime)) {
            System.out.println("Указанная дата наступит позже текущей.");
        } else {
            System.out.println("Указана текущая дата.");
        }
    }

    private static LocalDateTime getLocalDateTime(String dateTime) {
        try {
            return LocalDateTime.parse(dateTime, formatter);
        } catch (Exception e) {
            throw new RuntimeException("Дата указана некорректно.");
        }
    }
}
