package com.walking.lesson30_regex.task2;

import com.walking.lesson30_regex.task2.exception.FullNameValidationException;
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
    public static void main(String[] args) {
        FullName fullName = isValidFullName("Гордеев-Кулигин Константин Юрьевич");
        //FullName fullName1 = isValidFullName("Incognito Константин Юрьевич");

    }

    private static FullName isValidFullName (String name) {
        if (!name.matches("^[А-Я][а-я]*(-[А-Я][а-я]*)?\\s[А-Я][а-я]*\\s[А-Я][а-я]+$")) {

            throw new FullNameValidationException("Ошибка валидации фамилии");
        }
        String[] names = name.split("\\s");
        return new FullName(names[0], names[1], names[2]);
    }
}
