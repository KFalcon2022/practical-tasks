package com.walking.lesson27_generics.task1;

import com.walking.lesson27_generics.task1.model.GenericNumber;

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

    }
}
