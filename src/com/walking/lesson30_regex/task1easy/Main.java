package com.walking.lesson30_regex.task1easy;

import java.util.Scanner;
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
        String regex = "^\\+7\\s\\(\\d{3}\\)\\s\\d{3}-\\d{2}-\\d{2}$";
        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер телефона: ");
        String number = in.nextLine();

        if (isPhoneNumber(number, regex)) {
            System.out.println("Всё верно.");
        } else {
            throw new RuntimeException("Ошибка в данных.");
        }
    }

    public static boolean isPhoneNumber(String number, String regex) {
        return Pattern.matches(regex, number);
    }
}
