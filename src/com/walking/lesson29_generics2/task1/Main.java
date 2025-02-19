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
        Generic<String> stringGeneric = new Generic<>("qwer");
        System.out.println(getOrDefault(stringGeneric, "qw"));

        Generic<String> stringNull = new Generic<>(null);
        System.out.println(getOrDefault(stringNull, "qw"));

    }

    private static  <T> T getOrDefault(Generic<T> generic, T object) {
        return generic.getObject() != null ? generic.getObject() : object ;
    }
}
