package com.walking.lesson30_regex.task3;

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

import com.walking.lesson30_regex.task3.exception.notMatchedException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string:");
        String inputString = scanner.nextLine();
        scanner.close();

        if (inputString.matches("^((\\s*)([a-zA-Zа-яА-Я]+(-[a-zA-Zа-яА-Я]+)*))*$")) {
            String[] words = inputString.split("\\s+");
            int uniqCount = 0;

            for (int i = 0; i < words.length; i++) {
                boolean isUniq = true;
                int j = i + 1;
                while (j < words.length && isUniq) {
                    if (words[i].equals(words[j])) {
                        isUniq = false;
                    } else {
                        j++;
                    }
                }

                if (isUniq){
                    uniqCount++;
                }
            }
            System.out.printf("Uniq count = %d\n", uniqCount);
        } else {
            throw new notMatchedException();
        }

    }
}
