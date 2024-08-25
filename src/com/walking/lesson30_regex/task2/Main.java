package com.walking.lesson30_regex.task2;

import com.walking.lesson30_regex.task2.exception.FullNameIsNotValidException;

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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО");
        String fullName = scanner.nextLine();
        scanner.close();
        System.out.println(isValid(fullName));
    }

    public static FullName isValid(String fullName) {
        if (fullName.matches("^[А-Я][а-я]+ [А-Я][а-я]+ [А-Я][а-я]+$") ||
        fullName.matches("^[А-Я][а-я]+-[А-Я][а-я]+ [А-Я][а-я]+ [А-Я][а-я]+$")) {
            return new FullName(fullName);
        } else {
            throw new FullNameIsNotValidException("Некорректное ФИО");
        }
    }
}