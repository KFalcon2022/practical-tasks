package com.walking.lesson30_regex.task2;

import com.walking.lesson30_regex.task2.exception.NameNotValid;
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
    private final static String FULL_NAME_REGEX = "^[А-Я][а-я-]+ [А-Я][а-я]+ [А-Я][а-я]+$";
    private final static String DOUBLE_SURNAME_REGEX = "^[А-Я][а-я]+-[А-Я][а-я]+";
    private final static String NAME_REGEX = "^[А-Я][а-я]+";
    private final static String PATRONYMIC_REGEX = "[А-Я][а-я]+$";

    public static void main(String[] args) {
        String dude = "Зубенко Михаил Петрович";
        FullName fullName = createFullName(dude);
        System.out.println(fullName);
    }

    private static FullName createFullName(String dude) {
        if (!dude.matches(FULL_NAME_REGEX)) {
            throw new NameNotValid("Ошибка валидации ФИО.");
        }

        String[] fullName = dude.split(" ");

        String surname = fullName[0];
        validateSurname(surname);

        String name = fullName[1];
        validateName(name);

        String patronymic = fullName[2];
        validatePatronymic(patronymic);

        return new FullName(surname, name, patronymic);
    }

    private static void validateSurname(String name) {
        if (name.contains("-")) {
            if (!name.matches(DOUBLE_SURNAME_REGEX)) {
                throw new NameNotValid("Ошибка валидации в двойной фамилии.");
            }
        } else {
            validateName(name);
        }
    }

    private static void validateName(String name) {
        if (!name.matches(NAME_REGEX)) {
            throw new NameNotValid("Ошибка валидации в фамилии или имени.");
        }
    }

    private static void validatePatronymic(String name) {
        if (!name.matches(PATRONYMIC_REGEX)) {
            throw new NameNotValid("Ошибка валидации в отчестве.");
        }
    }
}
