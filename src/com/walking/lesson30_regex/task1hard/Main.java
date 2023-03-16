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
        /*  correct
                +7 (XXX) XXX-XX-XX
                +7(XXX)XXXXXXX
                +7(XXX)XXX-XX-XX
                +7(XXX)XXX-XXXX
                +7XXXXXXXXXX
                +7 XXX XXX XX XX
         */

        String correctTelNumber1 = "+7 (123) 456-78-90";
        String correctTelNumber2 = "+71234567890";
        String correctTelNumber3 = "+7(123)456-7890";
        String incorrectTelNumber1 = "+7(123) A45-67-89";
        String incorrectTelNumber2 = "+7(1234567890";
        String incorrectTelNumber3 = "+71(234)56-78-90";

        System.out.println(validateTelNumber(correctTelNumber1) + "\n" +
                (validateTelNumber(correctTelNumber2) + "\n" +
                        (validateTelNumber(correctTelNumber3) + "\n" +
                                (validateTelNumber(incorrectTelNumber1) + "\n" +
                                        (validateTelNumber(incorrectTelNumber2) + "\n" +
                                                (validateTelNumber(incorrectTelNumber3)
                                                ))))));





        /*System.out.println(validateTelNumber(correctTelNumber2));
        System.out.println(validateTelNumber(correctTelNumber3));
        System.out.println(validateTelNumber(incorrectTelNumber1));
        System.out.println(validateTelNumber(incorrectTelNumber2));
        System.out.println(validateTelNumber(incorrectTelNumber3));*/


    }
    static boolean validateTelNumber (String telNumber){
        //  [+]7\s?((\d{3})|\(\d{3}\))\s?\d{3}-?\s?\d{2}\s?-?\d{2}
        //  [+]7\s?\(\d{3}\)\s?\d{3}-?\s?\d{2}-?\s?\d{2}|[+]7\s?\d{3}\s?\d{3}\s?\d{2}\s?\d{2}
        Pattern pattern = Pattern.compile("[+]7\\s?((\\d{3})|\\(\\d{3}\\))\\s?\\d{3}-?\\s?\\d{2}\\s?-?\\d{2}");
        Matcher matcher = pattern.matcher(telNumber);

        while (matcher.find()) {
            return true;
        }
        return false;

    }
}
