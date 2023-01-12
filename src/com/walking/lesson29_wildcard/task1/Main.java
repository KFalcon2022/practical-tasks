package com.walking.lesson29_wildcard.task1;

import com.walking.lesson29_wildcard.task1.model.SomeGeneric;

public class Main {
    public static void main(String[] args) {
        SomeGeneric<String> someGeneric = new SomeGeneric<>();

        System.out.println(getValue(someGeneric, "test1"));
    }

    public static <E> E getValue(SomeGeneric<E> someGeneric, E element) {
        return someGeneric.getField() == null ?  element : someGeneric.getField();
    }
}
