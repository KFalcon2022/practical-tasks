package com.walking.lesson29_generics2.task1;

import com.walking.lesson29_generics2.task1.model.GenericType;

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
        GenericType <?> genericType = new GenericType<>(1234);
        GenericType <?> genericType1 = new GenericType<>(null);

    }

    private static <T> T genericMethod (GenericType <T> genericType, T param) {
        return genericType.getObject() != null ? genericType.getObject() : param;
    }
 }
