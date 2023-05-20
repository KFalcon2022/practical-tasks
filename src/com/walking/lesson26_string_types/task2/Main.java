package com.walking.lesson26_string_types.task2;

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

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string:");
        String input = scanner.nextLine();
        scanner.close();

        String[] strings = input.split("\s");

        for (int i=0; i < strings.length; i++ ) {
            if (strings[i].isBlank()){
                continue;
            }
            int count = 0;
            int lastIdx = 0;

            while (lastIdx != -1){
                lastIdx = input.indexOf(strings[i],lastIdx);
                if (lastIdx != -1){
                    count++;
                    lastIdx += lastIdx + strings[i].length();
                }
            }

            System.out.printf("%s = %d\n", strings[i], count);

            for (int j = i + 1; j < strings.length; j++){
                if (strings[i].equals(strings[j])){
                  strings[j] = "";
                }
            }
        }
//            System.out.println(string);
    }

}
