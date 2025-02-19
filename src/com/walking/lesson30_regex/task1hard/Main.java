package com.walking.lesson30_regex.task1hard;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your number: ");
        String phoneNumber = scan.nextLine();

        scan.close();

        System.out.println(isValidPhoneNumber(phoneNumber));
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        Pattern phoneNumberPattern = Pattern.compile("^([+]7)\\s?(\\(\\d{3}\\)|\\d{3})\\s?(\\d{3}(-)\\d{2}(-)\\d{2}|\\d{7})$");
        Matcher matcher = phoneNumberPattern.matcher(phoneNumber);
        return matcher.matches();
    }
}

