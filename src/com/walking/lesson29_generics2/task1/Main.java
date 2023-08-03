package com.walking.lesson29_generics2.task1;

import com.walking.lesson29_generics2.task1.model.GenericClass;

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
        GenericClass<String> genericClassNull = new GenericClass<>();
        GenericClass<Integer> integerGenericClass = new GenericClass<>(123);

        String string = "Test";
        Integer integer = 2;

        System.out.println(get(integerGenericClass,integer));
        System.out.println(get(genericClassNull,string));
    }
    public static  <T> T get (GenericClass<T> obj, T param) {
        return obj.getField() != null ? obj.getField() : param;
    }

}
