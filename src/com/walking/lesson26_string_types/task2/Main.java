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
        String phrase  = scanner.nextLine();
        scanner.close();

        phrase.strip();

        String[] words = phrase.split(" ");

        System.out.println(compareWords(words));
    }

    public static int compareWords(String[] words) {
        int amount = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(" " + words[0] + " ");

        for (int i = 0; i < (words.length - 1); i++) {
                int result = words[i].compareToIgnoreCase(words[i+1]);
                if (result > 0 || result < 0) {
                    if (!(sb.toString().contains(" " + words[i+1] + " "))) {
                        sb.append(words[i+1] + " ");
                        amount++;
                    }
                }
        }

        return amount;
    }
 }
