package com.walking.lesson28_generics1.task4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>(new Integer[]{1, 8, 7, 10});
        System.out.println(Arrays.toString(integerStack.toStringArray()));
        integerStack.addElement(52);
        System.out.println(integerStack.getSize());
        System.out.println(Arrays.toString(integerStack.toStringArray()));
        integerStack.deleteElement();
        System.out.println(Arrays.toString(integerStack.toStringArray()));
    }
}