package com.walking.lesson34_date_time.task1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Реализуйте метод, возвращающий объект LocalDateTime на основании переданной строки.
 * Пример входящей строки: 20.12.2022 20:16:00.
 */
public class Main {
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.y HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        System.out.print("Введите дату: ");
        Scanner in = new Scanner(System.in);
        String date = in.nextLine();

        LocalDateTime dateTime = getLocalDateTime(date);
        System.out.println(dateTime);
    }

    public static LocalDateTime getLocalDateTime(String dateTime) {
        try {
            return LocalDateTime.parse(dateTime, formatter);
        } catch (Exception e) {
            throw new RuntimeException("Дата указана некорректно.");
        }
    }
}
