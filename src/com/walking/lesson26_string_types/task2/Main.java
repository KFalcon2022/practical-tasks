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
        Scanner in = new Scanner(System.in);
        System.out.print("Введите фразу: ");
        String phrase = in.nextLine();

        System.out.printf("Найдено уникальных слов: %d", countWords(splitPhrase(phrase)));
    }

    public static String[] splitPhrase(String phrase) {
        return phrase.trim()
                .toLowerCase()
                .split(" ");
    }

    public static int countWords(String[] phrase) {
        int counter = 0;
        boolean isEqual;
        for (int i = 0; i < phrase.length; i++) {
            isEqual = isEqual(phrase, i);

            if (!isEqual) {
                counter--;
            }

            counter++;
        }

        return counter;
    }

    public static boolean isEqual(String[] phrase, int num) {
        for (int i = num + 1; i < phrase.length; i++) {
            if (phrase[num].equals(phrase[i])) {
                return false;
            }
        }

        return true;
    }
}
