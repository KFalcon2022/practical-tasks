package com.walking.lesson34_date_time.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Реализуйте программу, выводящую в консоль сообщение,
 * являются ли введенные с клавиатуры дата и время больше или меньше текущего.
 */
public class Main {
    public static final DateTimeFormatter DATE_TIME_PATTERN = DateTimeFormatter.ofPattern("dd.MM.yyy kk:mm:ss");

    public static void main(String[] args) {
        System.out.println("Введите дату и время в формате dd.mm.yyyy kk:mm:ss (например 20.12.2022 20:16:00):");

        String inputTimeDate = getDateTimeFromConsole();

        try {
            LocalDateTime input = parseLocalDateTime(inputTimeDate);

            System.out.printf("Введенные дата и время %s %s текущей (%s)"
                    .formatted(input.format(DATE_TIME_PATTERN), afterOrBeforeThanNow(input), LocalDateTime.now().format(DATE_TIME_PATTERN)));

        } catch (DateTimeException e) {
            System.out.println("Дата или время введены неверно");
        }
    }

    public static String getDateTimeFromConsole() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("io exception", e);
        }
    }

    public static LocalDateTime parseLocalDateTime(String localDateTimeCandidate) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd.MM.yyy kk:mm:ss");

        return LocalDateTime.parse(localDateTimeCandidate, pattern);
    }

    public static String afterOrBeforeThanNow(LocalDateTime input) {
        return input.isAfter(LocalDateTime.now()) ? "больше" : "меньше";
    }
}
