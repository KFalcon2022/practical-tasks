package com.walking.lesson34_date_time.task3;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAmount;
import java.util.Scanner;

/**
 * Реализуйте программу, выводящую в консоль количество времени между двумя
 * введенными с клавиатуры датами и временем в секундах, минутах, часах, днях, месяцах и годах.
 */
public class Main {
    public static final String FORMAT = "dd.MM.yyyy HH:mm;ss";
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT);

    public static void main(String[] args) {
        System.out.println("Введите две даты в формате: 20.12.2022 16:35:21");
        Scanner scanner = new Scanner(System.in);
        String date1 = scanner.nextLine();
        String date2 = scanner.nextLine();
        scanner.close();
    }

    public static void print() {

    }
}
