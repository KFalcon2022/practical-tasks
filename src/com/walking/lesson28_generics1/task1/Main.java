package com.walking.lesson28_generics1.task1;

/**
 * Создать обобщенный тип, принимающий в себя любого из наследников Number.
 * Создать метод, возводящий значение параметризованного типа в степень,
 * переданную параметром в метод.
 */
public class Main {
    public static void main(String[] args) {
        ToExp<Double> exp = new ToExp<>();
        System.out.println(exp.exponentiation(3.0,3 ));

    }

    public static class ToExp<T extends Number> {

        public T exponentiation(T num, Integer exp) {
            Double result = num.doubleValue();

            for (int i = 1; i < exp; i++) {
                result *= (double) exp;
            }
            return (T)result;

        }
    }
}
