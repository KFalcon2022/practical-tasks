package com.walking.lesson30_regex.task3;

import com.walking.lesson30_regex.task3.exception.InvalidWordException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private static final String WORD = "[а-яa-z]+";
    private static final String WORD_WITH_HYPHENS = "[а-яa-z][а-яa-z-]+[а-яa-z]";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите фразу: ");
        String phrase = in.nextLine()
                .trim()
                .toLowerCase();

        System.out.printf("Найдено уникальных слов: %d", countWords(splitPhrase(phrase)));
    }

    public static int countWords(String[] phrase) {
        int counter = 0;
        boolean isEqual;
        for (int i = 0; i < phrase.length; i++) {
            isEqual = isUnique(phrase, i);

            if (!isEqual) {
                counter--;
            }

            counter++;
        }

        return counter;
    }

    public static String[] splitPhrase(String phrase) {
        String[] words = phrase.split("\\s+");
        for (String word : words) {
            if (!validateWord(word)) {
                throw new InvalidWordException("Некорректное слово: " + word);
            }
        }
        return words;
    }

    public static boolean validateWord(String word) {
        if (!word.contains("-")) {
            return word.matches(WORD);
        }

        Pattern multiplyHyphens = Pattern.compile("--+");
        Matcher matcher = multiplyHyphens.matcher(word);
        if (matcher.find()) {
            return false;
        }

        return word.matches(WORD_WITH_HYPHENS);
    }

    public static boolean isUnique(String[] phrase, int num) {
        for (int i = num + 1; i < phrase.length; i++) {
            if (phrase[num].equals(phrase[i])) {
                return false;
            }
        }

        return true;
    }
}
