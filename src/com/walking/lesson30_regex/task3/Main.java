package com.walking.lesson30_regex.task3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.walking.lesson28_generics1.task4.model.Stack;

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
        System.out.println("Insert some words:");
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();
        sc.close();
        System.out.printf("You inserted %d unique word(s)", getCountUniqueWords(input));
    }
    private static int getCountUniqueWords(String s){
        Pattern pattern=Pattern.compile("[а-яА-ЯA-Za-z-]+");
        Matcher matcher=pattern.matcher(s);
        Stack<String> stack=new Stack<>();
        while (matcher.find()) {
            if (!matcher.group().matches("^.*-{2,}.*$")){
                stack.push(matcher.group());
            }
        }
        String[] arr=new String[stack.length()];
        for (int i=0; i<arr.length; i++){
            arr[i]=stack.pop();
        }
        String[] unique=new String[arr.length];
        unique[0]=arr[0];
        boolean flag;
        int uniqueCounter=1;
        for (int i=1; i<arr.length;i++){
            flag=true;
            for (int j=0; j<uniqueCounter;j++){
                if (arr[i].equals(unique[j]))
                    flag=false;
            }
            if (flag){
                unique[uniqueCounter]=arr[i];
                uniqueCounter++;
            }
        }
        return uniqueCounter;
    }
}
