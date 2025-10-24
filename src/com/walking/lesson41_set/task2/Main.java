package com.walking.lesson41_set.task2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

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

        HashSet<String> uniqueWords = getSetOfUniqueWords(phrase);
        System.out.printf("Найдено уникальных слов: %d", uniqueWords.size());
    }

    public static HashSet<String> getSetOfUniqueWords(String phrase) {
        String[] words = phrase.trim()
                .toLowerCase()
                .split(" ");

        return new HashSet<>(Arrays.asList(words));
    }
}
