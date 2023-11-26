package com.walking.lesson29_generics2.task1;

/**
изучал по дженерикам на разных источниках, но подглядел в разборе заданий.
 не мог понять строку ТЗ "где второй параметр обькт типа, которым параметризирован обьект первого типа... игра слов

 */
public class Main {
    public static void main(String[] args) {

        SimpleClass<Integer> one = new SimpleClass<>(null);
        System.out.println(checkThis(one, 7));

        SimpleClass<Integer> two = new SimpleClass<>(5);
        System.out.println(checkThis(two, 7));
    }

    private static <T> T checkThis(SimpleClass<T> i, T defaultType) {

        if (i.getField() != null) {
            return i.getField();
        }

        return defaultType;
    }


}
