package com.walking.lesson30_regex.task3;

import com.walking.lesson30_regex.task3.exception.StringNotValidateException;

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
    private static final String REGEX_STRING = "[А-Яа-я]+( )?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner("цукцук цукцук цукцук цукцук");

        System.out.print("Enter text: ");
        String[] text = cleaningText(scanner.nextLine())
                .trim()
                .toLowerCase()
                .split(" ");

        foundUniqueWords(text);
    }


    private static String cleaningText(String text) {
        if (!text.matches(REGEX_STRING)) {
            throw new StringNotValidateException("Валидация текста не пройдена.");
        }

        return text;
    }

    private static void foundUniqueWords(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 1 + i; j < words.length; j++) {
                if (words[i].equals(words[j]) && !words[i].equals(" ")) {
                    words[j] = " ";
                    count++;
                }
            }
        }

        System.out.printf("Unique words: %d \n", words.length - count);
    }
}
