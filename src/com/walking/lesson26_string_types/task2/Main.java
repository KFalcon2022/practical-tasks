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
        int numberUniqueWords = 0;
        boolean check;

        Scanner in = new Scanner(System.in);
        String wordsLine;

        System.out.println("Введите слова");
        wordsLine = in.nextLine();

        in.close();

        String[] words = wordsLine.toLowerCase().trim().split(" ");

        for (int i = 0; i < words.length; i++) {
            check = false;
            for (int j = 0; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    if (i == j) {
                        continue;
                    }
                    check = true;
                    break;
                }
            }

            if (!check) {
                numberUniqueWords++;
            }
        }

        System.out.println("Количество уникальных слов: " + numberUniqueWords);
    }
}
