package com.walking.lesson26_string_types.task2;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

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

        String someString = scanner.nextLine();

        System.out.println(countUniqueWords(someString));
    }

    public static int countUniqueWords(String s) {

        String[] allWords = s.trim()
                .toLowerCase()
                .split(" ");

        int count = 0;
        for (int i = 0; i < allWords.length; i++) {
            int j = 0;
            boolean isUnique = true;
            while (j < i && isUnique) {
                if (allWords[i].equals(allWords[j])) {
                    isUnique = false;
                } else {
                    j++;
                }
            }

            if (isUnique) {
                count++;
            }
        }

        return count;
    }
}
