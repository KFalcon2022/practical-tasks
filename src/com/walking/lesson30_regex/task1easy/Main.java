package com.walking.lesson30_regex.task1easy;

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
        String input = " +7 (921) 123-45-67";
        System.out.println(validatePhoneNumber(input));
    }

    private static boolean validatePhoneNumber(String input) {
        return input.matches("\\s*\\+7\\s\\(\\d{3}\\)\\s\\d{3}-\\d{2}-\\d{2}\\s*");
    }
}
