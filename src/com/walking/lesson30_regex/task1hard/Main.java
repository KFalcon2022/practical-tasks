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
    private static boolean isValidPhoneNumber(String number){
        final String phoneNumberRegex="^\\+7\\s?\\(?\\d{3}\\)?\\s?\\d{3}-?\\d{2}-?\\d{2}$";
        return number.matches(phoneNumberRegex)&&isValidSpace(number)&&isValidBracket(number)&&isValidHyphen(number);
    }
    private static boolean isValidSpace(String number){
        if (number.contains(" ")) {
            return number.matches("[^ ]+ [^ ]+ [^ ]+");
        }
        return true;
    }
    private static boolean isValidBracket(String number){
        if (number.contains("(")||number.contains(")")){
            return number.matches(".+[(].+[)].+");
        }
        return true;
    }
    private static boolean isValidHyphen(String number){
        if (number.contains("-")){
            return number.matches("[^-]+-[^-]+-[^-]+");
        }
        return true;
    }
}
