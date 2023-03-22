package com.walking.lesson41_set.task2;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson26_string_types/task2">...</a>,
 * используя Set.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter words: ");
        HashSet<String> words = new HashSet<>(List.of(scanner.nextLine()
                .trim()
                .toLowerCase()
                .split(" ")));

        scanner.close();

        System.out.printf("Found %d unique words\n", words.size());
    }
}
