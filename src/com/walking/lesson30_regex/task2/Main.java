package com.walking.lesson30_regex.task2;

import com.walking.lesson30_regex.task2.exception.ValidationException;
import com.walking.lesson30_regex.task2.information.FullName;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static final String SURNAME_WITH_HYPHEN_REGEX = "^[А-Я][а-я]+-[А-Я][а-я]+$";
    public static final String USUAL_NAME_REGEX = "^[А-Я][а-я]+$";

    public static void main(String[] args) {
        String someName = "Ниязов Алексей Рустамович";
        System.out.println(getFullName(someName));

    }

    private static FullName getFullName(String input) {
        String[] arrayID = input.split(" ");
        FullName fullName = new FullName(arrayID[1], arrayID[0], arrayID[2]);

        if (isValidFullName(fullName)) {
            return fullName;
        }

        throw new ValidationException("Input data is invalid");
    }

    private static boolean isValidFullName(FullName fullName) {

        return isValidSurname(fullName.getSurname())
                && isValidName(fullName.getFirstName())
                && isValidName(fullName.getFathersName());
    }

    private static boolean isValidSurname(String surname) {
        if (surname.contains("-")) {
            if (isValidName(SURNAME_WITH_HYPHEN_REGEX, surname)) {
                return true;
            }
        }

        return isValidName(surname);
    }

    private static boolean isValidName(String regex, String name) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);

        return matcher.find();
    }

    private static boolean isValidName(String name) {
        Pattern pattern = Pattern.compile(USUAL_NAME_REGEX);
        Matcher matcher = pattern.matcher(name);

        return matcher.find();
    }
}
