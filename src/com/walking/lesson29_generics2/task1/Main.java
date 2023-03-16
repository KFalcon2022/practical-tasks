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
        Generic<String> greeting = new Generic<>();
        greeting.setField1("Hello!");

        System.out.println(doSth(greeting, "Bye!"));

    }

    private static<T> T  doSth(Generic obj, T param){
        if (obj.getField1() != null){
            return (T)obj.getField1();
        } else {
            return param;
        }
    }
}
