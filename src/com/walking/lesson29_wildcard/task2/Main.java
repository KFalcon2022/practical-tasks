package com.walking.lesson29_wildcard.task2;

import com.walking.lesson29_wildcard.task2.model.GenericNumber;

public class Main {
    public static void main(String[] args) {

        GenericNumber<Integer> integerGenericNumber = new GenericNumber<>(15);
        GenericNumber<Double> doubleGenericNumber = new GenericNumber<>(15.);
        GenericNumber<Long> longGenericNumber = new GenericNumber<>(15L);
        GenericNumber<Float> floatGenericNumber = new GenericNumber<>(15f);

        System.out.println(integerGenericNumber.pow(4));

        System.out.println(doubleGenericNumber.pow(4));

        System.out.println(longGenericNumber.pow(4));

        System.out.println(floatGenericNumber.pow(4));

        GenericNumber<? extends Number> wrap = wrap(45);
        System.out.println(wrap);
    }

    public static GenericNumber<? extends Number> wrap(Number number) {
       return new GenericNumber<>(number);
    }
}
