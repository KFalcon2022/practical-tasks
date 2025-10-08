package com.walking.lesson29_generics2.task1;

import com.walking.lesson29_generics2.task1.generics.Generic1;

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
        Generic1<Double> generic1 = new Generic1<>(3.4);
        System.out.println(method(generic1, 8.0));
    }

    public static <T> T method(Generic1<T> generic1, T param) {
        return generic1.getField() != null ? generic1.getField() : param;
    }
}
