package com.walking.lesson29_generics2.task1;

import com.walking.lesson29_generics2.task1.model.Generic1;

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
        Generic1<Integer> notNullObject = new Generic1<>(25);
        System.out.println(getOrDefault(notNullObject, 240));

        Generic1<Integer> nullObject = new Generic1<>(null);
        System.out.println(getOrDefault(nullObject, 240));
    }

    private static <T> T getOrDefault(Generic1<T> object, T defaultField) {
        if (object == null) {
            return defaultField;
        }

        return object.getNumber();
    }
}
