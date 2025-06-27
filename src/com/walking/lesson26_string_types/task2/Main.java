package com.walking.lesson26_string_types.task2;

import java.util.Scanner;

/**
 * Реализуйте программу, принимающую с клавиатуры строку,
 * содержащую слова, разделенные пробелом.
 * Выведите в консоль количество уникальных слов в строке.
 * Учтите, что строка может начинаться с пробела.
 * <p>
 * Пример:
 * <p>
 * <code>Мама мыла раму мама рамы мыла. Пример строки</code>
 * <p>
 * В данном случае будем считать, что уникальных слов 6: мама, мыла, раму, рамы, пример, строки.
 * <p>
 * Для упрощения допустим, что в строке не могут использоваться символы,
 * отличные от пробела или русских/английский букв.
 * Помните, что слово может быть введено в разных регистрах.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a words: ");
        String[] array = scanner.nextLine()
                .trim()
                .toLowerCase()
                .split(" ");

        scanner.close();

        System.out.println(getWordsCounter(array));
    }

    private static String getWordsCounter(String[] array) {
        int wordsCounter = 0;

        for (int i = 0; i < array.length; i++) {
            boolean isUnique = validateUnique(array, i);

            if (isUnique) {
                wordsCounter++;
            }
        }

        return "Found " + wordsCounter + " unique words";
    }

    private static boolean validateUnique(String[] array, int i) {
        int j = 0;
        while (j < i) {
            if (array[i].equals(array[j])) {
                return false;
            }

                j++;
        }
        return true;
    }
}
