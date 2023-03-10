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
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Line: ");
        String line = sc.nextLine().strip().toLowerCase();
        sc.close();

        String[] words = line.split(" ");
        int doublingCount = 0;

            for (int i = 0; i < words.length - 1; i++) {
                int j = 0;
                while (j < i) {
                    if (words[j].equals(words[i])) {
                        doublingCount++;
                        break;
                    }else {
                        j++;
                    }
                }
            }
        for (String word:words) {
            System.out.println(word);
        }
        System.out.println("\nNumber of unique words: " + (words.length - doublingCount));
    }
}
