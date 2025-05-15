package com.walking.lesson29_generics2.task1;

import com.walking.lesson29_generics2.task1.service.Generic1;

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
        Generic1<String> genericString = new Generic1<>("Hello");
        System.out.println(getSmth(genericString, "Okay"));
        Generic1<Integer> genericInt = new Generic1<>(null);
        System.out.println(getSmth(genericInt, 8));
    }

    public static <T> T getSmth(Generic1<T> generic, T object) {
        T something = generic.getObject();
        if (something == null) {
            return object;
        }

        return something;
    }
}
