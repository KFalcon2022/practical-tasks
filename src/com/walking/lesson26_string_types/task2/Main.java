package com.walking.lesson26_string_types.task2;

import java.util.Scanner;

/**
 * Реализуйте программу, принимающую с клавиатуры строку,
 * содержащую слова, разделенные пробелом.
 * Выведите в консоль количество уникальных слов в строке.
 * Учтите, что строка может начинаться с пробела.
 * <p>
 * Для упрощения допустим, что в строке не могут использоваться символы,
 * отличные от пробела или русских/английский букв.
 * Помните, что слово может быть введено в разных регистрах.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your words: ");
        String[] words = scanner.nextLine()
                .trim()
                .toLowerCase()
                .split(" ");

        scanner.close();

        int uniqueWordsCounter = findUniqueWords(words);
        System.out.println(uniqueWordsCounter);
    }

    private static int findUniqueWords(String[] words) {
        int counter = 0;

        for (int i = 0; i < words.length; i++) {
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
}

