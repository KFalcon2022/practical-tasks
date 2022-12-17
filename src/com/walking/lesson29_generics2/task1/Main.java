package com.walking.lesson29_generics2.task1;

import com.walking.lesson29_generics2.task1.model.Generic;

/**
 * Реализуйте обобщенный тип, хранящий параметризованное поле.
 * Также в классе Main реализуйте параметризованый метод,
 * принимает первым параметром объект вашего дженерика,
 * вторым — объект типа, которым параметризован объект первого параметра.
 * Метод должен возвращать значение поля дженерика, если оно != null,
 * в противном случае — возвращать второй параметр.
 */
public class Main {
    public static void main(String[] args) {
        Generic<Integer> notNullValue = new Generic<>(1);
        System.out.println(getOrDefault(notNullValue, 2));

        Generic<Integer> nullValue = new Generic<>(null);
        System.out.println(getOrDefault(nullValue, 2));
    }

    private static <T> T getOrDefault(Generic<T> object, T defaultObject) {
        return object.getObject() != null ? object.getObject() : defaultObject;
    }
}
