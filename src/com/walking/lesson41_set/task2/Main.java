package com.walking.lesson41_set.task2;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson26_string_types/task2">...</a>,
 * используя Set.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter words: ");
        String[] words = scanner.nextLine()
                .trim()
                .toLowerCase()
                .split(" ");

        scanner.close();

//        Пройти foreach по words, добавляя каждый элемент в сет - тоже решение.
//        Правда, IDEA порекомендует заменить его на set.addAll()
        Set<String> uniqueWords = new HashSet<>(List.of(words));

        System.out.printf("Found %d unique words\n", uniqueWords.size());
    }
}
