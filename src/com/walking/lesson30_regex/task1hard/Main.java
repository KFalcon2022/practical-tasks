package com.walking.lesson30_regex.task1hard;

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
        String number = "+79999999999";
        System.out.println(check(number));
    }

    private static boolean check(String str) {
        Pattern pattern = Pattern.compile("^\\+7\\s?\\(?\\d{3}\\)?\\s?\\d{3}\\-?\\d{2}\\-?\\d{2}$");
        Matcher matcher = pattern.matcher(str);

        return matcher.matches();
    }
}
