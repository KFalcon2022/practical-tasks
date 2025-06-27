package com.walking.lesson30_regex.task1hard;

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

        //Да, я уже посмотрел решение и понял, что я не выполнил условие задачи до конца)
        String phoneNumber = "+7 (914) 029-00-24";

        if (isPhoneNumber(phoneNumber)) {
            System.out.println("It is a Phone Number!");
        } else {
            System.out.println("It is not a Phone Number!");
        }
    }

    private static boolean isPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^\\+7\\s?\\(?\\d{3}\\)?\\s?\\d{3}-?\\d{2}-?\\d{2}$");
    }
}
