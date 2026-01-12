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
        Scanner in = new Scanner(System.in);
        System.out.print("Введите фразу: ");
        String phrase = in.nextLine();

        Set<String> uniqueWords = getUniqueWords(phrase);
        System.out.printf("Найдено уникальных слов: %d", uniqueWords.size());
    }

    public static Set<String> getUniqueWords(String phrase) {
        String[] words = phrase.trim()
                .toLowerCase()
                .split(" ");

        return new HashSet<>(Arrays.asList(words));
    }
}
