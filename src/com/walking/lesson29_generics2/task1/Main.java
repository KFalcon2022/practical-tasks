package com.walking.lesson29_generics2.task1;

import com.walking.lesson29_generics2.task1.service.Generic;

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
        Generic<String> genericString = new Generic<>("Hello");
        System.out.println(getSmth(genericString, "Okay"));
        Generic<Integer> genericInt = new Generic<>(null);
        System.out.println(getSmth(genericInt, 8));
    }

    public static <T> T getSmth(Generic<T> generic, T object) {
        T genericObject = generic.getObject();
        if (genericObject == null) {
            return object;
        }

        return genericObject;
    }
}
