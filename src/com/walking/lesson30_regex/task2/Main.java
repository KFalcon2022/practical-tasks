package com.walking.lesson30_regex.task2;

import com.walking.lesson30_regex.task2.model.FullName;
import com.walking.lesson30_regex.task2.service.NameValidationService;

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
 * Если невалидна – бросьте из метода исключение, указывающее нК ошибку валидации.
 */
public class Main {
    public static void main(String[] args) {
        String fullNameFromUser = getFullNameFromUser();

        FullName validFullName = NameValidationService.getFullName(fullNameFromUser);

        System.out.println(validFullName);

//        System.out.println(NameValidationService.getFullName("Иванов Иван Иванович"));
//        System.out.println(NameValidationService.getFullName("Иванов-Иванов Иван Иванович"));
//        System.out.println(NameValidationService.getFullName("Иванов-Иванов И Иванович"));
//        System.out.println(NameValidationService.getFullName("И-Иванов И Иванович"));

//        System.out.println(NameValidationService.getFullName("Иванов иван Иванович"));
//        System.out.println(NameValidationService.getFullName("И-иванов И Иванович"));
//        System.out.println(NameValidationService.getFullName("Иванов Иван иванович"));
//        System.out.println(NameValidationService.getFullName("ИваНов Иван Иванович"));
//        System.out.println(NameValidationService.getFullName("Ivanov Ivan"));
    }

    public static String getFullNameFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                 Введите русскоязычное ФИО.
                 Фамилия, имя и отчество должны начинаться с прописной буквы
                 и быть разделены пробелами.
                 Фамилия может быть двойной и писаться через дефис
                 (каждая часть фамилии начинается с прописной буквы):
                """);

        String fullName = scanner.nextLine();

        scanner.close();

        return fullName;
    }
}
