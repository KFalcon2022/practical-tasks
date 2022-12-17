package com.walking.lesson30_regex.task2;

import com.walking.lesson30_regex.task2.exception.RegexValidationException;
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

    public static final String FULL_NAME_REGEX = "^[А-Я][А-Яа-я-]* [А-Я][а-я]* [А-Я][а-я]+$";
    public static final String DOUBLE_SURNAME_REGEX = "[А-Я][а-я]*-[А-Я][а-я]*";
    public static final String NAME_REGEX = "[А-Я][а-я]*";
    public static final String PATRONYMIC_REGEX = "[А-Я][а-я]+";

    public static void main(String[] args) {
        System.out.println(parseName("Иванов Иван Иванович"));
        System.out.println(parseName("Иванов-Иванов Иван Иванович"));
        System.out.println(parseName("Иванов-Иванов И Иванович"));
        System.out.println(parseName("И-Иванов И Иванович"));
        System.out.println(parseName("Иванов иван Иванович"));
//        Все равно упадет на 30й строке.
//        System.out.println(parseName("И-иванов И Иванович"));
//        System.out.println(parseName("Иванов Иван иванович"));
//        System.out.println(parseName("ИваНов Иван Иванович"));
//        System.out.println(parseName("Ivanov Ivan"));
    }

    private static FullName parseName(String nameString) {
        if (!nameString.matches(FULL_NAME_REGEX)) {
            throw new RegexValidationException(nameString, FULL_NAME_REGEX);
        }

        FullName fullName = new FullName();
        String[] splitNameString = nameString.split(" ");

        String surname = splitNameString[0];
        validateSurname(surname);
        fullName.setSurname(surname);

        String name = splitNameString[1];
        validateName(name);
        fullName.setName(name);

        String patronymic = splitNameString[2];
        validatePatronymic(patronymic);
        fullName.setPatronymic(patronymic);

        return fullName;
    }

    private static void validateSurname(String surname) {
        if (surname.contains("-")) {
            if (!surname.matches(DOUBLE_SURNAME_REGEX)) {
                throw new RegexValidationException(surname, DOUBLE_SURNAME_REGEX);
            }
        } else {
            validateName(surname);
        }
    }

    private static void validateName(String name) {
        if (!name.matches(NAME_REGEX)) {
            throw new RegexValidationException(name, NAME_REGEX);
        }
    }

    private static void validatePatronymic(String name) {
        if (!name.matches(PATRONYMIC_REGEX)) {
            throw new RegexValidationException(name, PATRONYMIC_REGEX);
        }
    }
}
