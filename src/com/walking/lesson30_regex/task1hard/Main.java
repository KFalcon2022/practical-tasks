package com.walking.lesson30_regex.task1hard;

import java.util.Scanner;

/**
 * Реализуйте boolean-метод, валидирующий входящую строку.
 * Метод должен возвращать true,
 * если строка соответствует номеру мобильного телефона
 * (в качестве примера привожу номер для РФ, вы можете выбрать любой другой, но со схожей маской).
 * <p>
 * Маска корректного номера: +7 (XXX) XXX-XX-XX,
 * где "X" – цифра от 0 до 9.
 * <p>
 * Символы скобок, дефиса и пробелов – опциональны
 * (каждый из них может или присутствовать, как на оригинальной маске,
 * так и отсутствовать вовсе, возможность частичного использования
 * или использования символов-разделителей в другом порядке считаем невалидным)
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер телефона в формате +7 (XXX) XXX-XX-XX");
        String phoneNumber = scanner.nextLine();
        scanner.close();

        System.out.println(isValid(phoneNumber));
    }

    public static boolean isValid(String phoneNumber) {
        if (!phoneNumber.contains("(") && !phoneNumber.contains(")")
                && !phoneNumber.contains(" ") && !phoneNumber.contains("-")) {
            return phoneNumber.matches("\\+\\d{11}");
        }
        return isValidSpace(phoneNumber) && isValidBrackets(phoneNumber) && isValidHyphen(phoneNumber);
    }

    private static boolean isValidBrackets(String phoneNumber) {
        if (phoneNumber.contains("(") || phoneNumber.contains(")")) {
            return phoneNumber.matches("^\\+7\\s?\\(\\d{3}\\)\\s?\\d{3}-?\\d{2}-?\\d{2}$");
        }
        return true;
    }

    private static boolean isValidHyphen(String phoneNumber) {
        if (phoneNumber.contains("-")) {
            return phoneNumber.matches("^\\+7\\s?\\(?\\d{3}\\)?\\s?\\d{3}-\\d{2}-\\d{2}$");
        }
        return true;
    }

    private static boolean isValidSpace(String phoneNumber) {
        if (phoneNumber.contains(" ")) {
            return phoneNumber.matches("^\\+7 \\(?\\d{3}\\)? \\d{3}-?\\d{2}-?\\d{2}$");
        }
        return true;
    }

}
