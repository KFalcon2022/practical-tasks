package com.walking.lesson30_regex.task1easy;

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
        String testPhoneNumber = "+7 (123) 456-78-90";

        System.out.println(isValidPhoneNumber(testPhoneNumber));

        System.out.println(isValidPhoneNumber("+7 (121) 333-23-43"));
        System.out.println(isValidPhoneNumber("+7 (121) 3332343"));
        System.out.println(isValidPhoneNumber("+7 121 333-23-43"));
        System.out.println(isValidPhoneNumber("+7(121)333-23-43"));
        System.out.println(isValidPhoneNumber("+7(121)3332343"));
        System.out.println(isValidPhoneNumber("+71213332343"));
        System.out.println(isValidPhoneNumber("+7 (1121) 333-23-43"));
        System.out.println(isValidPhoneNumber("+7(121) 333-23-43"));
        System.out.println(isValidPhoneNumber("+7 121) 333-23-43"));
        System.out.println(isValidPhoneNumber("+7 (121)333-23-43"));
        System.out.println(isValidPhoneNumber("+(7 121)333-23-43"));
        System.out.println(isValidPhoneNumber("+7 (121) 333-2343"));
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        //через явное создание экземпляров Pattern и Matcher
        Pattern phoneNumberPattern = Pattern.compile("^\\+7\\s\\(\\d{3}\\)\\s\\d{3}-\\d{2}-\\d{2}$");

        Matcher phoneNumberMatcher = phoneNumberPattern.matcher(phoneNumber);

        return phoneNumberMatcher.find();
    }
}
