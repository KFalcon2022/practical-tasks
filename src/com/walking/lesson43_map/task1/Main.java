package com.walking.lesson43_map.task1;

import com.walking.lesson43_map.task1.exception.ValidationException;

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
    public final static String WORD_REGEX = "[a-z]+";
    public final static String DASH_WORD_REGEX = "[a-z][a-z-]+[a-z]+";
    public final static String INPUT_WORDS_REGEX = "[a-z-\\s]+";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введи слова: ");

        String wordsString = scanner.nextLine()
                .trim()
                .toLowerCase();

        scanner.close();


        if (!wordsString.matches(INPUT_WORDS_REGEX)) {
            throw new ValidationException(wordsString, INPUT_WORDS_REGEX);
        }

        String[] words = wordsString.split("\\s+");

        Map<String, Integer> uses = getUsages(words);

        System.out.println(uses.toString());
    }

    private static Map<String, Integer> getUsages(String[] words) {
        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            validateWord(words[i]);

            Integer count = result.get(words[i]);
            result.put(words[i], count == null ? 1 : count + 1);
        }

        return result;
    }

    private static void validateWord(String word) {
        if (word.contains("-")) {
            if (!word.matches(DASH_WORD_REGEX)) {
                throw new ValidationException(word, DASH_WORD_REGEX);
            }

            for (String part : word.split("-")) {
                validateSimpleWord(part);
            }

            return;
        }

        validateSimpleWord(word);
    }

    private static void validateSimpleWord(String word) {
        if (!word.matches(WORD_REGEX)) {
            throw new ValidationException(word, WORD_REGEX);
        }
    }
}
