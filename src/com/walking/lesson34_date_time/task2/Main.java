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

        System.out.println("Enter a datetime:");
        LocalDateTime date = LocalDateTime.parse(scanner.nextLine(), FORMATTER);

        scanner.close();

        LocalDateTime currentDate = LocalDateTime.now()
//                Не обязательное дополнение, округляет текущую дату до секунд.
//                Учитывая, что now() вернет время с точностью до наносекунд - это может иметь смысл, в
//                зависимости от прикладного назначения программы
                .truncatedTo(ChronoUnit.SECONDS);

//        Безусловно, эту задачу можно решить проще через сравнение через compareTo(),
//        но такое решение не будет закреплять тему классов даты и времени
        if (date.isBefore(currentDate)) {
            System.out.println("Date is before now");
        } else if (date.isAfter(currentDate)) {
            System.out.println("Date is after now");
        } else {
            System.out.println("Dates are equal");
        }
    }
}
