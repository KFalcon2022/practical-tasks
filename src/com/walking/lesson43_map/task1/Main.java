package com.walking.lesson43_map.task1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Реализуйте программу, выводящую в консоль количество использований каждого слова во введенной пользователем строке.
 * <p>
 * За основу предлагаю взять реализацию из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson30_regex/task3">...</a>.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a words: ");
        String[] words = scanner.nextLine()
                .trim()
                .toLowerCase()
                .split(" ");
        scanner.close();

        Map<String, Integer> uniqueWords = new HashMap<>();
        for (String s : words) {
            int count = uniqueWords.getOrDefault(s, 0);
            uniqueWords.put(s, ++count);
        }

        System.out.println("Уникальных слов -> " + uniqueWords);
    }
}
