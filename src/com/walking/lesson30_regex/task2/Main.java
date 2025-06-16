package com.walking.lesson30_regex.task2;

import com.walking.lesson30_regex.task2.exeption.InvalidFullNameException;
import com.walking.lesson30_regex.task2.service.FullName;

import java.util.Scanner;

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
    private static final String FULL_NAME_REGEX = "[А-Я][А-Яа-я-]* [А-Я][а-я]* [А-Я][а-я]*";
    private static final String NAME_REGEX = "[А-Я][а-я]*";
    private static final String DOUBLE_SURNAME_REGEX = "[А-Я][а-я]*-[А-Я][а-я]*";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String fullName = in.nextLine();
        getFullName(fullName).printFullName();
    }

    public static FullName getFullName(String fullName) {
        if (!isFullNameValid(fullName)) {
            throw new InvalidFullNameException();
        }
        String[] fullNameArr = fullName.split(" ");
        if (isSurnameValid(fullNameArr[0]) && isNameValid(fullNameArr[1]) && isNameValid(fullNameArr[2])) {
            return new FullName(fullNameArr[0], fullNameArr[1], fullNameArr[2]);
        }
        throw new InvalidFullNameException();
    }

    public static boolean isFullNameValid(String fullName) {
        return fullName.matches(FULL_NAME_REGEX);
    }

    public static boolean isSurnameValid(String surname) {
        if (surname.matches(DOUBLE_SURNAME_REGEX)) {
            return true;
        }

        return isNameValid(surname);
    }

    public static boolean isNameValid(String name) {
        return name.matches(NAME_REGEX);
    }
}
