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
    public static void main(String[] args) {
        String someName = "Ниязов Алексей Рустамович";
        System.out.println(getFullName(someName));

    }

    private static FullName getFullName(String input) {
        String[] arrayID = input.split(" ");
        String secondName = arrayID[0];
        String firstName = arrayID[1];
        String fathersName = arrayID[2];
        /// Да да, я понимаю, что так делать нельзя
        /// слёзно прошу помочь с решением этого момента
        /// или же я что-то увижу в решении)
        /// это всё до коммита и пуша)

        if (isValidName(secondName, firstName, fathersName)) {
            return new FullName(firstName, secondName, fathersName);
        }

        throw new ValidationException("Input data is invalid");
    }

    private static boolean isValidName(String secondName, String firstName, String fathersName) {
        boolean isValidName = isValidStringWithHyphen(secondName)
                && isValidString(firstName)
                && isValidString(fathersName);

        if (isValidName) {
            return true;
        }

        throw new RuntimeException("not valid");
    }

    private static boolean isValidStringWithHyphen(String name) {
        if (name.contains("-")) {
            if (isValidString("^[А-Я][а-я]+-[А-Я][а-я]+$", name)) {
                return true;
            }
        }

        return isValidString(name);
    }

    private static boolean isValidString(String regex, String secondName) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(secondName);

        return matcher.find();
    }

    private static boolean isValidString(String name) {
        /// Это же будет считаться перегрузкой?)

        Pattern pattern = Pattern.compile("^[А-Я][а-я]+$");
        Matcher matcher = pattern.matcher(name);

        return matcher.find();
    }
}

/// Я ЗАЕБАЛСЯ, ЭТО МАКСИМУМ ДЕКОМПОЗИЦИИ, НА КАКУЮ Я СЕЙЧАС СПОСОБЕН)
/// ДО ЭТОГО БЫЛО 200 СТРОК ПРИМЕРНО)