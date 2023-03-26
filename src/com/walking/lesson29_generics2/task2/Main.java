package com.walking.lesson29_generics2.task2;



/**
 * Используя Задачу 1 из урока Generics.
 * Часть I, реализуйте в Main метод, принимающий аргументом объект подходящего
 * для дженерика типа и возвращающий объект дженерика.
 * Допустима параметризация только с использованием wildcard.
 */
public class Main {
    public static void main(String[] args) {
        NumDegree <?> n1 = createGeneric(2);
        NumDegree <?> n2 = createGeneric((short)3);
        NumDegree <?> n3 = createGeneric(4.0);

        System.out.println(n1.doThis(3));
        System.out.println(n2.doThis(3));
        System.out.println(n3.doThis(4));
    }

    static <T extends Number> NumDegree<?> createGeneric(T value){
        return new NumDegree<>(value);
    }
}
