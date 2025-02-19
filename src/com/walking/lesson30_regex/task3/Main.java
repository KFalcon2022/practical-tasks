package com.walking.lesson30_regex.task3;

import com.walking.lesson30_regex.task3.exception.InvalidWordsException;

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
    public static final String SPLIT = "\\s+";
    public static final String WORDS_PATTERN = "[a-z-\\s]+";
    public static final String WORD_PATTERN = "[a-z][a-z-?]+[a-z]*";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your words: ");
        String words = scanner.nextLine()
                .trim()
                .toLowerCase();

        if (!isValidWords(words)) {
            throw new InvalidWordsException(words);
        }

        scanner.close();

        String[] wordsArray = words.split(SPLIT);

        int uniqueWordsCounter = findUniqueWords(wordsArray);
        System.out.println(uniqueWordsCounter);
    }

    private static int findUniqueWords(String[] words) {
        int counter = 0;

        for (int i = 0; i < words.length; i++) {
            if(!isValidWord(words[i])) {
                throw new InvalidWordsException(words[i]);
            }

            boolean isUnique = true;

            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                counter++;
            }
        }

        return counter;
    }

    private static boolean isValidWords(String words) {
        Pattern wordsPattern = Pattern.compile(WORDS_PATTERN);
        Matcher matcherWord = wordsPattern.matcher(words);
        return matcherWord.matches();
    }

    private static boolean isValidWord(String word) {
        Pattern wordPattern = Pattern.compile(WORD_PATTERN);
        Matcher matcherWord = wordPattern.matcher(word);
        return matcherWord.matches();
    }
}
