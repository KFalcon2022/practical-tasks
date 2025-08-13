package com.walking.lesson34_date_time.task2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date and time:");
        String date = scanner.nextLine();
        scanner.close();

        LocalDateTime userDateTime = getDateTimeFromString(date);

        System.out.println(userDateTime.isAfter(LocalDateTime.now()) ?
                "The entered date and time is greater than the current one.":
                "The entered date and time is less than the current one.");
    }

    public static LocalDateTime getDateTimeFromString(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        LocalDateTime localDateTime = LocalDateTime.parse(date, dateTimeFormatter);

        return localDateTime;
    }
}