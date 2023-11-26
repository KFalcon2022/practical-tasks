package com.walking.lesson28_generics1.task1;

import com.walking.lesson28_generics1.task1.Number.Number;

public class Main {
    public static void main(String[] args) {
        Number<Integer> number = new Number<>(5);
        System.out.println(number.ExponentNumber(3));
    }
}
