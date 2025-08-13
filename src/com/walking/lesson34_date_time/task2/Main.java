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
    public static final String FORMATTER_PATTERN = "dd-MM-yyyy HH:mm:ss";
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATTER_PATTERN);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter date and time: ");
        LocalDateTime userInputDateTime = LocalDateTime.parse(sc.nextLine(), formatter);
        sc.close();

        LocalDateTime currentTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);

        if (currentTime.isBefore(userInputDateTime)) {
            System.out.println("Введенное время больше текущего.");
        } else if(currentTime.isAfter(userInputDateTime)) {
            System.out.println("Введенное время меньше текущего.");
        } else if (currentTime.isEqual(userInputDateTime)) {
            System.out.println("Введенное время равно текущему");
        }

    }
}
