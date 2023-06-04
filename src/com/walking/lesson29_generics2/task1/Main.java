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

        Generic <?> g = new Generic<String>("2ss");
        System.out.println(genericNvl(g,1));
    }

    static <T> T genericNvl(Generic<?> gen, T val){
        if (gen.getValue()!=null){
            return (T) gen.getValue();
        }
        return val;
    }


}
