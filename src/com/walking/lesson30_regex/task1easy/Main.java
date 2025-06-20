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
        String phoneNumber = "+7 (914) 029-00-24";

        if (isPhoneNumber(phoneNumber)) {
            System.out.println("It is a Phone Number!");
        } else {
            System.out.println("It is not a Phone Number!");
        }
    }

    private static boolean isPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\+\\d\\s\\(\\d{3}\\)\\s\\d{3}-\\d{2}-\\d{2}");
    }
}
