package com.walking.lesson41_set.task2;

import java.util.*;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson26_string_types/task2">...</a>,
 * используя Set.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Введи слова через пробел: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine()
                .trim()
                .toLowerCase();

        scanner.close();

        String[] strArr = str.split(" ");

        Set<String> uniqueWords = new HashSet<>(List.of(strArr));

        System.out.println(uniqueWords.size());

        System.out.println(uniqueWords);
    }
}
