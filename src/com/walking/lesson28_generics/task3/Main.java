package com.walking.lesson28_generics.task3;

import com.walking.lesson28_generics.task3.model.ArrayWrapper;

public class Main {
    public static void main(String[] args) {
        ArrayWrapper<Object> arrayWrapper = new ArrayWrapper<>(new Integer[]{1,5,8,7,4,6,5});
        arrayWrapper.findValueInArray(10);
    }
}
