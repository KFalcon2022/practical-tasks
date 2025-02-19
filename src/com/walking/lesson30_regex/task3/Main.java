package com.walking.lesson30_regex.task3;

import com.walking.lesson30_regex.task3.exception.ValidException;

import java.util.Locale;
import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson26_string_types/task2/Main.java">...</a>
 * Теперь слова в исходном массиве могут быть разделены несколькими пробелами,
 * а также знаками табуляции и иными пробельными символами.
 * Словами считаются лишь подстроки,
 * состоящие из буквенных символов или содержащие в середине слова один
 * или несколько дефисов, но не более одного подряд.
 * При наличии в исходной строке невалидных символов или некорректном использовании допустимых,
 * должно быть выброшено исключение.
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
            throw new ValidException(wordsString, INPUT_WORDS_REGEX);
        }

        String[] words = wordsString.split("\\s+");

        int count = countUniqueWords(words);

        System.out.println(count);
    }

    private static int countUniqueWords(String[] words) {
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            validateWord(words[i]);

            if (isUnique(words, i)) {
                count++;
            }
        }

        return count;
    }

    private static boolean isUnique(String[] words, int indexWord) {
        int i = 0;

        while (i < words.length) {
            if (i == indexWord) {
                i++;
                continue;
            }

            if (words[indexWord].equals(words[i])) {
                return false;
            }

            i++;
        }

        return true;
    }

    private static void validateWord(String word) {
        if (word.contains("-")) {
            if (!word.matches(DASH_WORD_REGEX)) {
                throw new ValidException(word, DASH_WORD_REGEX);
            }

            for (String part : word.split("-")) {
                validateSimpleWord(part);
            }
        } else {
            validateSimpleWord(word);
        }
    }

    private static void validateSimpleWord(String word) {
        if (!word.matches(WORD_REGEX)) {
            throw new ValidException(word, WORD_REGEX);
        }
    }
}
