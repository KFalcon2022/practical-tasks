package com.walking.lesson34_date_time.task2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Реализуйте программу, выводящую в консоль сообщение,
 * являются ли введенные с клавиатуры дата и время больше или меньше текущего.
 */
public class Main {
    public final static String FORMAT = "dd.MM.yyyy HH:mm:ss";
    public final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(FORMAT);

    public static void main(String[] args) {
        System.out.println("Введите дату в формате: 20.12.2022 20:16:00");
        Scanner scanner = new Scanner(System.in);
        String inputDate = scanner.nextLine();
        scanner.close();

        compareDates(inputDate);
    }

    public static void compareDates(String inputDate) {
        LocalDateTime input = LocalDateTime.parse(inputDate, FORMATTER);
        LocalDateTime nowDate = LocalDateTime.now();

        if (input.isBefore(nowDate)) {
            System.out.println("Введеная дата меньше текущей");
        } else {
            System.out.println("Введеная дата больше текущей");
        }
    }
}
