package com.walking.lesson43_map.task1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Реализуйте программу, выводящую в консоль количество использований каждого из уникальных слов
 * во введенной пользователем строке.
 * <p>
 * За основу предлагаю взять реализацию из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson30_regex/task3">...</a>.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a words: ");
        String[] s = scanner.nextLine()
                .trim()
                .toLowerCase()
                .split(" ");
        scanner.close();

        Map<String, Integer> uniqueWords = new HashMap<>();
        uniqueWords.put(s[0], 1);

        for (int i = 1; i < s.length; i++) {
            if (uniqueWords.containsKey(s[i])) {
                uniqueWords.put(s[i], uniqueWords.get(s[i]) + 1);
            } else {
                uniqueWords.put(s[i], 1);
            }
        }

        System.out.println(uniqueWords);
    }
}
