package com.walking.lesson43_map.task1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Реализуйте программу, выводящую в консоль количество использований каждого из уникальных слов в введенной пользователем строке.
 * За основу предлагаю взять реализацию из задачи 3 урока 30.
 */
public class Main {
    public static final String WORDS_REGEX = "[a-z-\\s]+";
    public static final String COMPLEX_WORD_REGEX = "[a-z][a-z-]+[a-z]";
    public static final String WORD_REGEX = "[a-z]+";

    public static void main(String[] args) {

        Map<String, Integer> wordsMap = new HashMap<>();

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

        //Сложность зашкаливает)
        Arrays.stream(wordArray).forEach(word -> wordsMap.merge(word, 1, Integer::sum));

        int counter = wordsMap.size();

        System.out.printf("Found %d unique words\n", counter);
    }
}
