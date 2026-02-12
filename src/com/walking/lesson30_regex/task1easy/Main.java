package com.walking.lesson30_regex.task1easy;

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
 * Обратите внимание на наличие скобок и пробелов.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number:");
        String number = "+7 999 303 09 34";

        scanner.close();

        System.out.println(isContains(number));
    }

    public static boolean isContains(String number) {
        Pattern pattern = Pattern.compile("^\\+7\\s?\\(?\\d{3}\\)?\\s?\\d{3}[\\s-]?\\d{2}[\\s-]?\\d{2}$");

        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
}
