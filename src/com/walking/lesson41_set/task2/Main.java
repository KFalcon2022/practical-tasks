package com.walking.lesson41_set.task2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson26_string_types/task2">...</a>,
 * используя Set.
 */
public class Main {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter words: ");
        String[] words = SCANNER.nextLine()
                .trim()
                .toLowerCase()
                .split(" ");

        SCANNER.close();
        Set<String> wordsHashSet = new HashSet<>();

        for (String s : words) {
            wordsHashSet.add(s);
        }

        System.out.printf("Found %d unique words", wordsHashSet.size());
        System.out.println(wordsHashSet);
    }
}
