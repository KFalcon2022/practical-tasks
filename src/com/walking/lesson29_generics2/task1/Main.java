package com.walking.lesson29_generics2.task1;

import com.walking.lesson29_generics2.task1.model.Gen;

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
        Gen<String> gen=new Gen<>();
        System.out.println(getValue(gen, "Hi"));
        gen.value="Hello";
        System.out.println(getValue(gen, "Hi"));
    }

    private static <S> S getValue(Gen<S> gen, S s){
        if(gen.value!=null){
            return gen.value;
        }
        return s;
    }
}
