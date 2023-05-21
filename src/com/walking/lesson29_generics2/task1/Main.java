package com.walking.lesson29_generics2.task1;

/**
 * Реализуйте обобщенный тип, хранящий параметризованное поле.
 * Также в классе Main реализуйте параметризованый метод,
 * принимает первым параметром объект вашего дженерика,
 * вторым — объект типа, которым параметризован объект первого параметра.
 * Метод должен возвращать значение поля дженерика, если оно != null,
 * в противном случае — возвращать второй параметр.
 */

import com.walking.lesson29_generics2.task1.model.Store;

public class Main {
    public static void main(String[] args) {

        Store<Integer> storeInteger = new Store<>(32);
        System.out.println(getGeneric(storeInteger,34));

        Store<Integer> storeNull = new Store<>(null);
        System.out.println(getGeneric(storeNull,34));

    }

    private static <T> T getGeneric(Store<T> store, T instance) {

        if (store.getInstance() != null) {
            return store.getInstance();
        } else {
            return instance;
        }

    }
}
