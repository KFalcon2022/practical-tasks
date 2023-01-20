package com.walking.lesson29_generics2.task2;

import com.walking.lesson29_generics2.task2.Generic;
public class Main {
    public static void main(String[] args) {
        Generic<?> integerGeneric = getGen(5);
        System.out.println(integerGeneric.exponentiateGeneric(3));
    }

    public static Generic<? extends Number>  getGen(Number param) {

        return new Generic<>(param);
    }
}