package com.walking.lesson37_collection_list.task2;

import java.util.Arrays;

import com.walking.lesson37_collection_list.task2.model.Stack;

/**
 * Попробуйте реализовать собственную коллекцию, наследуясь от Collection.
 * За основу можно взять
 * <a href="https://github.com/KFalcon2022/practical-tasks/tree/master/src/com/walking/lesson28_generics1/task4">...</a>.
 * Если возникнет необходимость в имплементации методов,
 * не рассмотренных в статье - можете реализовать их как заглушки
 * (возвращая null/фиксированное значение по умолчанию/бросая исключение).
 */
public class Main {
    public static void main(String[] args) {
                Stack<String> stack=new Stack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println(stack.peek());
        stack.add("4");
        System.out.println(stack.peek());
        stack.addAll(Arrays.asList("5","6"));
        String[] stringArray=new String[5];
        stringArray=stack.toArray(stringArray);
        System.out.println(stack.peek());
        for (String string : stack) {
            System.out.println(string);
        }
        System.out.println("Contains 4:"+stack.contains("4"));
        System.out.println("Contains 4,5:"+stack.containsAll(Arrays.asList("4","5")));
        System.out.println("is empty: "+stack.isEmpty());
        for (String s:stack.getStrings()){
            System.out.println(s);
        }
        stack.remove("3");
        for (String s:stack.getStrings()){
            System.out.println(s);
        }
        stack.removeAll(Arrays.asList("4","5"));
        for (String s:stack.getStrings()){
            System.out.println(s);
        }
        stack.retainAll(Arrays.asList("2","3"));
        for (String s:stack.getStrings()){
            System.out.println(s);
        }
    }
}
