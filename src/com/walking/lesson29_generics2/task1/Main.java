package com.walking.lesson29_generics2.task1;

import com.walking.lesson29_generics2.task1.model.CustomGeneric;

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
        Object[] objects = new Object[]{"STRING VALUE", null, 666, new CustomGeneric<>("INNER VALUE")};
        CustomGeneric<?> customGeneric;

        for (Object object : objects) {
            customGeneric = new CustomGeneric<>(object);
            System.out.println(getGenericValue(customGeneric, "DEFAULT VALUE"));
        }

    }

    public static <T> T getGenericValue(CustomGeneric<? extends T> producer, T defaultValue) {
        return producer.getField() != null ? producer.getField() : defaultValue;
    }
}
