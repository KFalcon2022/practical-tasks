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
        Generic<Integer> generic = new Generic<>(1);
        System.out.println(toggleValue(generic, 3));

        Generic<Integer> generic2 = new Generic<>(null);
        System.out.println(toggleValue(generic2, 4));
    }

    public static <T> T toggleValue(Generic<T> obj, T t) {
        if (obj.getField() != null) {
            return obj.getField();
        }
        return t;
    }
}
