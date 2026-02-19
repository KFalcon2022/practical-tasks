package com.walking.lesson43_map.task1;

import com.walking.lesson43_map.task1.exception.RegexValidationException;

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
    public static final String WORDS_REGEX = "[a-z-\\s]+";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter words: ");
        String words = scanner.nextLine()
                .trim()
                .toLowerCase();

        scanner.close();

        if (!words.matches(WORDS_REGEX)) {
            throw new RegexValidationException(words, WORDS_REGEX);
        }

        String[] wordArray = words.split("\\s+");
        // black green white black green white black green white blue

        Map<String, Integer> uniqueWords = countUniqueWordsUsages(wordArray);

        for (Map.Entry<String, Integer> word : uniqueWords.entrySet()) {
            System.out.printf("Word '%s' used %d times\n", word.getKey(), word.getValue());
        }
    }

    private static Map<String, Integer> countUniqueWordsUsages(String[] words) {
        Map<String, Integer> uniqueWords = new HashMap<>();

        for (String word : words) {
            int count = uniqueWords.getOrDefault(word, 0) + 1;
            uniqueWords.put(word, count);
        }

        return uniqueWords;
    }
}
