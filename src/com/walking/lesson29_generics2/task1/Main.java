package com.walking.lesson29_generics2.task1;

public class Main {
    public static void main(String[] args) {
        Generic1<String> stringGeneric1 = new Generic1<>(null);
        Generic1<Integer> integerGeneric1 = new Generic1<>(57);
        System.out.println(getValue(stringGeneric1, "Hello"));
        System.out.println(getValue(integerGeneric1, 16));

    }

    public static <T> T getValue(Generic1<T> generic1, T param) {
       if (generic1.getField() == null) {
           return param;
       }

       return generic1.getField();
    }
}