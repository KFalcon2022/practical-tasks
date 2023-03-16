package com.walking.lesson30_regex.task2;

import com.walking.lesson30_regex.task2.exceptions.InvalidNameException;
import com.walking.lesson30_regex.task2.model.FullName;

import java.util.Arrays;
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

        String user1 = "Вагина Ольга Михайловна";
        String user2 = "Пидорняк константин Николаевич";
        String user3 = "Тысяча-Извинений Рамазан Ахматович";

        FullName userObj = validator(user3);
        System.out.println(userObj.getLastName() + " " + userObj.getFirstName() + " " + userObj.getSurname());

    }

    static FullName validator (String name) throws RuntimeException{
        if (name.matches("^(([А-Я,Ё][а-я,ё]+)|([А-Я,Ё][а-я,ё]+-[А-Я,Ё][а-я,ё]+))\\s([А-Я,Ё][а-я,ё]+)\\s([А-Я,Ё][а-я,ё]+)$")){
            String [] nameSplit = name.split(" ");

            return new FullName(nameSplit[1], nameSplit[0], nameSplit[2]);
        }
        throw new InvalidNameException("Invalid Name!");
    }
}
