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

        System.out.println("Введите строку, содержашую слова, разделенные пробелом:");

        String input = scanner.nextLine();

        scanner.close();

        int amountUniqueWordsInString = countUniqueWords(input);

        System.out.printf("Количество уникальных слов в строке: %d\n", amountUniqueWordsInString);
    }

    private static int countUniqueWords(String input) {
        int counter = 0;

        String[] words = input.trim()
                              .toLowerCase()
                              .split(" ");

        for (int i = 0; i < words.length; i++) {
            if (isUniqueWord(words, i)) {
                counter++;
            }
        }

        return counter;
    }

    private static boolean isUniqueWord(String[] words, int currentIndex) {
        for (int i = currentIndex + 1; i < words.length; i++) {
            if (words[currentIndex].equals(words[i])) {
                return false;
            }
        }

        return true;
    }
}
