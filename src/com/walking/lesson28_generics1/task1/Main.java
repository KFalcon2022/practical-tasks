package com.walking.lesson28_generics1.task1;

public class Main {
    public static void main(String[] args) {
        Generic<Integer> genericInt = new Generic<>(3);
        Generic<Float> genericFloat = new Generic<>( 2.0f);
        System.out.println(genericInt.exponentiateGeneric(3.0));
        System.out.println(genericFloat.exponentiateGeneric(5.0));
    }

    public static class Generic<T extends Number> {
        private T number;

        public Generic(T number) {
            this.number = number;
        }

        public double exponentiateGeneric(double exponent) {

            return Math.pow(number.doubleValue(), exponent);
        }
    }
}
