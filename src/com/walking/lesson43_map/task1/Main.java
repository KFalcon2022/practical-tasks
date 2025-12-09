package com.walking.lesson43_map.task1;

import com.walking.lesson30_regex.task3.exception.InvalidWordException;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Реализуйте программу, выводящую в консоль количество использований каждого слова во введенной пользователем строке.
 * <p>
 * За основу предлагаю взять реализацию из задачи
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson30_regex/task3">...</a>.
 */
public class Main {
    private static final String WORD = "[а-яa-z]+";
    private static final String WORD_WITH_HYPHENS = "[а-яa-z][а-яa-z-]+[а-яa-z]";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите фразу: ");
        String phrase = in.nextLine()
                .trim()
                .toLowerCase();

        var words = getWordsMap(phrase);
        System.out.println(words);

    }

    private static HashMap<String, Integer> getWordsMap(String phrase) {
        String[] words = splitPhrase(phrase);
        validateWords(words);

        var wordsMap = new HashMap<String, Integer>();
        for (String word : words) {
            putElement(wordsMap, word);
        }

        return wordsMap;
    }

    private static void putElement(HashMap<String, Integer> map, String key) {
        Integer amount = map.put(key, 1);
        if (amount != null) {
            map.replace(key, amount + 1);
        }
    }

    private static void validateWords(String[] words) {
        for (String word : words) {
            if (!isWordValid(word)) {
                throw new InvalidWordException("Некорректное слово: " + word);
            }
        }
    }

    private static boolean isWordValid(String word) {
        if (!word.contains("-")) {
            return word.matches(WORD);
        }

        if (word.matches("^.*--+.*$")) {
            return false;
        }

        return word.matches(WORD_WITH_HYPHENS);
    }

    private static String[] splitPhrase(String phrase) {
        return phrase.split("\\s+");
    }
}
