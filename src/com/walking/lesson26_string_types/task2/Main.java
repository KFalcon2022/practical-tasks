package com.walking.lesson26_string_types.task2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Реализуйте программу, принимающую с клавиатуры строку,
 * содержащую слова, разделенные пробелом.
 * Выведите в консоль количество уникальных слов в строке.
 * Учтите, что строка может начинаться с пробела.
 * <p>
 * Пример:
 * <p>
 * <code>Мама мыла раму мама рамы мыла Пример строки</code>
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

        System.out.println("Введите строку: ");

        String inStr = scanner.nextLine();

        scanner.close();

        System.out.println(countWords(inStr));
    }

    private static int countWords(String inStr) {
        String[] str = inStr.strip().toLowerCase().split(" ");

        if (str.length == 0) {
            return 0;
        }
        Arrays.sort(str);

        int count = 1;

        for (int i = 0; i < str.length - 1; i++) {
            String s = str[i].strip();

            if (!s.equals(str[i + 1])) {
                count++;
            }
        }
        return count;
    }
}
