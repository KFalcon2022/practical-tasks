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
    public static final String COMPLEX_WORD_REGEX = "[a-z][a-z-]+[a-z]";
    public static final String WORD_REGEX = "[a-z]+";

    public static void main(String[] args) {
        String words = getStringFromUser();

        if (!words.matches(WORDS_REGEX)) {
            throw new RegexValidationException(words, WORDS_REGEX);
        }

        Map<String, Integer> wordOccurrences = getWordOccurrences(words);
        printWordOccurrences(wordOccurrences);
    }

    public static String getStringFromUser() {
        System.out.println("Введите строку, содержащую слова, разделенные пробелом:");

        Scanner scanner = new Scanner(System.in);

        String words = scanner.nextLine()
                              .trim()
                              .toLowerCase();

        scanner.close();

        return words;
    }

    private static Map<String, Integer> getWordOccurrences(String words) {
        Map<String, Integer> wordOccurrences = new HashMap<>();
        Integer currentWordOccurrence;

        for (String word : words.split("\\s+")) {
            validateWord(word);
            currentWordOccurrence = wordOccurrences.getOrDefault(word, 0);
            wordOccurrences.put(word, ++currentWordOccurrence);
        }

        return wordOccurrences;
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

    private static void printWordOccurrences(Map<String, Integer> wordOccurrences) {
        for (Map.Entry<String, Integer> stringIntegerEntry : wordOccurrences.entrySet()) {
            System.out.printf("%s - %s\n", stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
        }
    }
}