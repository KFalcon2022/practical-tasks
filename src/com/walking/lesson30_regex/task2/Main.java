package com.walking.lesson30_regex.task2;

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

import com.walking.lesson30_regex.task2.model.FullName;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter full name:");
        String inputString = scanner.nextLine();
        scanner.close();

        FullName fullName = new FullName(inputString);

        System.out.print(fullName.toString());
    }
}
