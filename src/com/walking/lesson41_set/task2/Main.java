package com.walking.lesson41_set.task2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Реализуйте задачу
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson26_string_types/task2">...</a>,
 * используя Set.
 */
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
        Scanner sc=new Scanner(System.in);
        System.out.println("Введите строку:");
        String s=sc.nextLine();
        sc.close();
        String[] arr=s.strip().split(" ");
        HashSet<String> hs=new HashSet<>(arr.length);
        for (String string : arr) {
            hs.add(string);
        }
        System.out.printf("Вы ввели %d уникальных слов(а)", hs.size());
    }
}
