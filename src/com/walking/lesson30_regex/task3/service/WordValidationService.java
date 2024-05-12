package com.walking.lesson30_regex.task3.service;

import com.walking.lesson30_regex.task3.exception.InvalidWordException;

public class WordValidationService {
    private static final String VALID_WORD = "(?<ru>^[А-Яа-я]+(?:-[А-Яа-я]+)*$)|(?<en>^[A-Za-z]+(?:-[A-Za-z]+)*$)";

    private static String[] getValidWords(String input) {
        String[] validWords = input.trim()
                                   .split("\\s+");

        for (String candidateWord : validWords) {
            if (!isValidWord(candidateWord)) {
                throw new InvalidWordException(candidateWord);
            }
        }

        return validWords;
    }

    private static boolean isValidWord(String word) {
        return word.matches(VALID_WORD);
    }

    public static int countUniqueWords(String input) {
        String[] validWords = getValidWords(input);

        int counter = 0;

        for (int i = 0; i < validWords.length; i++) {
            if (isUniqueWord(validWords, i)) {
                counter++;
            }
        }

        return counter;
    }

    private static boolean isUniqueWord(String[] words, int currentIndex) {
        for (int i = 0; i < currentIndex; i++) {
            if (words[currentIndex].equalsIgnoreCase(words[i])) {
                return false;
            }
        }

        return true;
    }
}
