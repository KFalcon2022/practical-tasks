package com.walking.lesson30_regex.task3;


import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/blob/master/src/com/walking/lesson26_string_types/task2/Main.java">...</a>
 * Теперь слова в исходном массиве могут быть разделены несколькими пробелами,
 * а также знаками табуляции и иными пробельными символами.
 * Словами считаются лишь подстроки,
 * состоящие из буквенных символов или содержащие в середине слова один
 * или несколько дефисов, но не более одного подряд.
 * При наличии в исходной строке невалидных символов или некорректном использовании допустимых,
 * должно быть выброшено исключение.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку");
        String inputString = deleteExtraSpaces(scanner.nextLine().trim().toLowerCase());
        scanner.close();

        if (isInputValid(inputString)) {
            String[] words = inputString.split(" ");
            System.out.println(calculateUniqueWords(words));

        }
    }

    private static String deleteExtraSpaces(String input) {
        while (true) {
            if (input.contains("  ")) {
                input = input.replace("  ", " ");
            } else if (input.contains("\t")) {
                input = input.replace("\t", "");
            } else {
                return input;
            }
        }
    }

    private static boolean isWordValid(String word) {
        return word.matches("[a-z-а-я][a-zа-я-]+[a-zа-я]");
    }

    private static int calculateUniqueWords(String[] words) {
        int countUniqueWords = 0;
        for (int i = 0; i < words.length; i++) {
            boolean isUnique = true;
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique && isWordValid(words[i])) {
                countUniqueWords++;
            }
        }
        return countUniqueWords;
    }

    private static boolean isInputValid(String input) {
        if (input.contains("--")) {
            throw new RuntimeException("invalid input");
        }
        if (input.matches("^[а-я]+[а-я- ]+$")) {
            return true;
        }
        throw new RuntimeException("invalid input");
    }
}