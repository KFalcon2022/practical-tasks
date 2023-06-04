package com.walking.lesson30_regex.task3;

import java.util.ArrayList;
import java.util.Locale;

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
        /*
        Scanner in = new Scanner(System.in);
        String inStr = in.nextLine().trim();

         */
        String inStr = "   abc     cde dss  Abc aaa   ";
        String[] arrStr = inStr.trim().toLowerCase(Locale.ROOT).split("\\s+");
        ArrayList<String> uniq = new ArrayList<>();
        for (String s:arrStr) {
            if (s != null && !s.isBlank() && !uniq.contains(s)){
                uniq.add(s);
                System.out.println(s);
            }
        }
        System.out.println(uniq.size());

    }
}
