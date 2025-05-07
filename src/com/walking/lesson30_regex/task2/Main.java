package com.walking.lesson30_regex.task2;

import com.walking.lesson30_regex.task2.exception.ValidException;
import com.walking.lesson30_regex.task2.model.FullName;


/**
 * Реализуйте метод для работы с ФИО.
 * Входным параметром должна являться строка,
 * содержащая русскоязычное ФИО.
 * Фамилия, имя и отчество должны начинаться с прописной буквы
 * и быть разделены пробелами.
 * Фамилия может быть двойной и писаться через дефис
 * (каждая часть фамилии начинается с прописной буквы).
 * Если строка валидна – верните ФИО, обернутое в класс «Полное имя»,
 * содержащий фамилию, имя и отчество.
 * Если невалидна – бросьте из метода исключение, указывающее на ошибку валидации.
 */
public class Main {
    private final static String FULL_NAME_REGEX = "^[А-Я][а-я]+(-[А-Я][а-я]+)* [А-Я][а-я]+ [А-Я][а-я]+$";
    private final static String DOUBLE_SURNAME_REGEX = "^[А-Я][а-я]+-[А-Я][а-я]+$";
    private final static String NAME_REGEX = "[А-Я][а-я]+";

    public static void main(String[] args) {
        System.out.println(createFullName("Иванов Иван Иванович"));
        System.out.println(createFullName("Иванов-Иванов Иван Иванович"));
        System.out.println(createFullName("Иванов-Иванов Ив Иванович"));
        System.out.println(createFullName("Ив-Иванов Ив Иванович"));
        System.out.println(createFullName("Иванов иван Иванович"));
    }

    private static FullName createFullName(String str) {
        if (!str.matches(FULL_NAME_REGEX)) {
            throw new ValidException(str, FULL_NAME_REGEX);
        }

        String[] fullNameArray = str.split(" ");

        if (validateSurname(fullNameArray[0]) && validateName(fullNameArray[1]) && validateName(fullNameArray[2])) {
            return new FullName(fullNameArray[0], fullNameArray[1], fullNameArray[2]);
        }

        return null;
    }

    private static boolean validateSurname(String str) {
        if (str.contains("-")) {
            if (!str.matches(DOUBLE_SURNAME_REGEX)) {
                throw new ValidException(str, DOUBLE_SURNAME_REGEX);
            }
        } else {
            if (!str.matches(NAME_REGEX)) {
                throw new ValidException(str, NAME_REGEX);
            }
        }
        return true;
    }

    private static boolean validateName(String str) {
        if (!str.matches(NAME_REGEX)) {
            throw new ValidException(str, NAME_REGEX);
        }
        return true;
    }
}
