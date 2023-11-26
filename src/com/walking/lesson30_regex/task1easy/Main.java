package com.walking.lesson30_regex.task1easy;

import java.util.SortedMap;
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

        //          "+7 (XXX) XXX-XX-XX"


        String pattern = "[+]7\\s[(]\\d{3}[)]\\s\\d{3}-\\d{2}-\\d{2}";
        String correctTelNumber = "+7 (423) 240-40-00";
        String incorrectTelNumber = "+7(914) A12-34-56";

        System.out.println(validateTelNumber(correctTelNumber));
        System.out.println(validateTelNumber(incorrectTelNumber));


    }
    static boolean validateTelNumber (String telNumber){
        Pattern pattern = Pattern.compile("[+]7\\s[(]\\d{3}[)]\\s\\d{3}-\\d{2}-\\d{2}");
        Matcher matcher = pattern.matcher(telNumber);

        while (matcher.find()) {
            return true;
        }
        return false;

    }



}
