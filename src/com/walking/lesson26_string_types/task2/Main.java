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
        System.out.println("Введите строку");
        String[] inputWords = scanner.nextLine().trim().toLowerCase().split(" ");
        scanner.close();

        int uniqueWords = 0;
        for (int i = 0; i < inputWords.length; i++) {
            boolean isUnique = true;
            for (int j = i + 1; j < inputWords.length; j++) {
                if (inputWords[i].equals(inputWords[j]) || inputWords[i].isEmpty()) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                uniqueWords++;
            }
        }
    }
}
