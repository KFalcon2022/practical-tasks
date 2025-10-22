package com.walking.lesson30_regex.task3;

import com.walking.lesson30_regex.task3.exception.StringValidationException;

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
    private static final String invalidSymbolRegex = "--|[\\W_\\d]|- | -"; //недопустимые для использования символы
    private static final String splitRegex = "\\s+";
    private static final String emptyStringRegex = ".*\\S+.*"; //непробельная строка

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter words: ");
        String wordsString = scanner.nextLine()
                .trim() //обрезаем пробелы в начале и коне введенной строки
                .toLowerCase(); //приводим все к нижнему регистру, чтобы слова в разном регистре не посчитались по отдельности
                //.split(" "); //разбиваем строку на массив, разделенный по " "

        String[] words = splitString(wordsString);

        scanner.close();

        int counter = getCounter(words);

        System.out.printf("Found %d unique words\n", counter);
    }

    private static String[] splitString(String wordsString) {
        if (wordsString.matches(invalidSymbolRegex) || !hasWords(wordsString)) {
            throw new StringValidationException("Недопустимая строка :", wordsString);
        }

        return wordsString.split(splitRegex);
    }

    private static boolean hasWords(String wordsString) {
        return wordsString.matches(emptyStringRegex);
    }

    private static int getCounter(String[] words) {
        int counter = 0;
        for (int i = 0; i < words.length; i++) {
            // Каждое слово в массиве сравниваем с предыдущими словами того же массива.
            // Если слово эквивалентно одному из предыдущих - оно не уникально
            int j = 0;
            boolean isUnique = true;
            while (j < i && isUnique) {
                if (words[i].equals(words[j])) {
                    isUnique = false;
                } else {
                    j++;
                }
            }

            if (isUnique) {
                counter++;
            }
        }
        return counter;
    }
}

