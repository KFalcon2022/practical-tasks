package com.walking.lesson30_regex.task2;

import com.walking.lesson30_regex.task2.model.FullName;
import com.walking.lesson30_regex.task2.model.InputValidationException;

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
        FullName fullName = createCorrectFullName("Антонов Вадим Вадимыч");
        FullName fullName1 = createCorrectFullName("Антонов-Антонов Вадим Вадимыч");

        FullName invalidFullName = createCorrectFullName("АнтоноАнтонов Вадим Вадимыч");

    }

    public static FullName createCorrectFullName(String fullName) {
        if (isCorrectFullName(fullName)) {
            String [] splitFullName = fullName.split(" ");
            return  new FullName(splitFullName);
        }
        throw new InputValidationException();
    }
    public static boolean isCorrectFullName(String fullName) {
        String regex = "^[А-Я][а-я]*(-[А-Я][а-я]*)? [А-Я][а-я]* [А-Я][а-я]*$";
        return  fullName.matches(regex);
    }
}
