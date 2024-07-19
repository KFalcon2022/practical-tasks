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
        String testPhoneNumber = "+7 (123) 456-78-90";

        System.out.println(isValidPhoneNumber(testPhoneNumber));

        System.out.println("true:" + isValidPhoneNumber("+7 (121) 333-23-43"));
        System.out.println("true:" + isValidPhoneNumber("+7 (121) 3332343"));
        System.out.println("true:" + isValidPhoneNumber("+7 121 333-23-43"));
        System.out.println("true:" + isValidPhoneNumber("+7(121)333-23-43"));
        System.out.println("true:" + isValidPhoneNumber("+7(121)3332343"));
        System.out.println("true:" + isValidPhoneNumber("+71213332343"));
        System.out.println("false:" + isValidPhoneNumber("+7 (1121) 333-23-43"));
        System.out.println("false:" + isValidPhoneNumber("+7(121) 333-23-43"));
        System.out.println("false:" + isValidPhoneNumber("+7 121) 333-23-43"));
        System.out.println("false:" + isValidPhoneNumber("+7 (121)333-23-43"));
        System.out.println("false:" + isValidPhoneNumber("+(7 121)333-23-43"));
        System.out.println("false:" + isValidPhoneNumber("+7 (121) 333-2343"));
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        //через неявное создание экземпляров Pattern и Matcher внутри метода String.matches()
        final String phoneNumberRegex = "^\\+7\\s?\\(?\\d{3}\\)?\\s?\\d{3}-?\\d{2}-?\\d{2}$";

        return phoneNumber.matches(phoneNumberRegex)
                && isValidWhitespaces(phoneNumber)
                && isValidHyphens(phoneNumber)
                && isValidBrackets(phoneNumber);
    }

    private static boolean isValidWhitespaces(String phoneNumber) {
        final String correctWhitespacesRegex = "[^ ]+ [^ ]+ [^ ]+";

        if (phoneNumber.contains(" ")) {
            return phoneNumber.matches(correctWhitespacesRegex);
        }

        return true;
    }

    private static boolean isValidHyphens(String phoneNumber) {
        final String correctHyphensRegex = "[^-]+-[^-]+-[^-]+";

        if (phoneNumber.contains("-")) {
            return phoneNumber.matches(correctHyphensRegex);
        }

        return true;
    }

    private static boolean isValidBrackets(String phoneNumber) {
        final String correctBracketsRegex = "[^()]+\\([^()]+\\)[^()]+";

        if (phoneNumber.contains("(") || phoneNumber.contains(")")) {
            return phoneNumber.matches(correctBracketsRegex);
        }

        return true;
    }
}
