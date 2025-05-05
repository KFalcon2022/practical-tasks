package com.walking.lesson43_map.task1;

/**
 * Реализуйте программу, выводящую в консоль количество использований каждого слова во введенной пользователем строке.
 * <p>
 * За основу предлагаю взять реализацию из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson30_regex/task3">...</a>.
 */

import com.walking.lesson43_map.task1.Exception.RegexValidationException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static final String WORDS_REGEX = "[a-z-\\s]+";
    public static final String COMPLEX_WORD_REGEX = "[a-z][a-z-]+[a-z]";
    public static final String WORD_REGEX = "[a-z]+";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter words: ");
        String words = scanner.nextLine().trim().toLowerCase();

        scanner.close();

        if (!words.matches(WORDS_REGEX)) {
            throw new RegexValidationException(words, WORDS_REGEX);
        }

        String[] wordArray = words.split("\\s+");

        Map<String, Integer> map = countUniqueWordsUsages(wordArray);

        for (Map.Entry<String, Integer> entry : map.entrySet() ) {
            System.out.printf("%s : %d times\n", entry.getKey(), entry.getValue());
        }
    }


    private static Map<String, Integer> countUniqueWordsUsages(String[] wordArray) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : wordArray) {
            validateWord(word);

            int counter = map.getOrDefault(word, 0);
            map.put(word, ++counter);
        }

        return map;
    }


    private static void validateWord(String word) {
        if (word.contains("-")) {
            if (!word.matches(COMPLEX_WORD_REGEX)) {
                throw new RegexValidationException(word, COMPLEX_WORD_REGEX);
            }

            for (String wordPart : word.split("-")) {
                validateSimpleWord(wordPart);
            }
        } else {
            validateSimpleWord(word);
        }
    }

    private static void validateSimpleWord(String word) {
        if (!word.matches(WORD_REGEX)) {
            throw new RegexValidationException(word, WORD_REGEX);
        }
    }
}
