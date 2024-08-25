package com.walking.lesson29_generics2.task1;

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
        System.out.println(method(new Generic<>(null), "Generic field is null"));
    }

    public static <T> T method(Generic<T> generic, T object) {
        return generic.getField() != null ? generic.getField() : object;
    }
}
