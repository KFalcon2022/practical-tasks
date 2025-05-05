package com.walking.lesson41_set.task2;

import java.util.*;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson26_string_types/task2">...</a>,
 * используя Set.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase(Locale.ROOT);
        String[] arrayInput = input.trim().split(" ");

        Set<String> set = new HashSet<>(Arrays.asList(arrayInput));

        System.out.println(set.size());
    }
}
