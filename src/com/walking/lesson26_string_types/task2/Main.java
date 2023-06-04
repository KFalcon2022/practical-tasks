package com.walking.lesson26_string_types.task2;

import java.util.ArrayList;
import java.util.Locale;
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
        /*
        Scanner in = new Scanner(System.in);
        String inStr = in.nextLine().trim();

         */
        String inStr = "   abc     cde dss  Abc aaa   ";
        String[] arrStr = inStr.trim().toLowerCase(Locale.ROOT).split(" ");
        ArrayList <String> uniq = new ArrayList<>();
        for (String s:arrStr) {
            if (s != null && !s.isBlank() && !uniq.contains(s)){
                uniq.add(s);
            }
        }
        System.out.println(uniq.size());
        //here I try debugger(lesson 26)
        for (int i = 0; i < 100; i++){
            System.out.println(i);
        }
    }
}
