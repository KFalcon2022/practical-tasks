package com.walking.lesson26_string_types.task2;

import java.util.Locale;
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
        String input = scanner.nextLine().toLowerCase(Locale.ROOT);
        String[] arrayInput = input.trim().split(" ");
        int counter = 0;
        for (int i = 0; i < arrayInput.length; i++) {
            for (int j = 0; j < arrayInput.length; j++) {
                if (arrayInput[i].equals(arrayInput[j]) && i != j) {
                    counter--;
                    break;
                }
            }
            counter++;
        }
        System.out.println(counter);
    }
}
