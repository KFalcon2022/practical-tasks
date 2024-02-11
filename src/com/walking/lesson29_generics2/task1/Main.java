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
        GenericClass<String> genericObject1 = new GenericClass<>("String test");
        GenericClass<Integer> genericObject2 = new GenericClass<>();

        System.out.println(method(genericObject1,"Pussy"));
        System.out.println(method(genericObject2,123));
    }
    private static <T> T method(GenericClass<T> genericObj, T param){
        if (genericObj.getField()!=null){
            return genericObj.getField();
        }
        return param;
    }
}
