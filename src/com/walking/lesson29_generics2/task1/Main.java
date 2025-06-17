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
        int fieldForGeneric = 0;
        Generic1<Integer> generic1 = new Generic1<>(fieldForGeneric);
        System.out.println(method(generic1, 240));

        generic1 = null;

        System.out.println(method(generic1, 240));
    }

    private static <T> T method(Generic1<T> object, T field) {
        if (object == null) {
            return field;
        }

        return object.getField();
    }
}
