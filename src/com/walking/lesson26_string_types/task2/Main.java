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
        Scanner scanner = new Scanner("aa bb cc aa vv");

        System.out.print("Enter a words: ");
        String text = scanner.nextLine();

        String[] words = text.strip().toLowerCase().split(" ");
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = 1 + i; j < words.length; j++) {
                if(words[i].equals(words[j]) && !words[i].equals(" ")) {
                    words[j] = " ";
                    count++;
                }
            }
        }
        System.out.println(words.length - count * 2);
    }
}

