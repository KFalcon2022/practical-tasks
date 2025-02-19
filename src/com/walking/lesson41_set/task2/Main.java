package com.walking.lesson41_set.task2;

import java.util.Arrays;
import java.util.HashSet;
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

        System.out.println("Введите строку, содержашую слова, разделенные пробелом:");

        String input = scanner.nextLine();

        scanner.close();

        int amountUniqueWords = countUniqueWords(input);

        System.out.printf("Количество уникальных слов в строке: %d\n", amountUniqueWords);
    }

    private static int countUniqueWords(String allWords) {
        String[] splittedWords = allWords.trim()
                                         .toLowerCase()
                                         .split(" ");

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(splittedWords));

        return uniqueWords.size();
    }
}