package com.walking.lesson28_generics1.task1.model;

public class GenericExponente<T extends Number>{
    private final T number;

    public GenericExponente(T number) {
        this.number = number;
    }

    public T getNumber() {
        return number;
    }

    public double exponentiate (double exponente) {
        return Math.pow(number.doubleValue(), exponente);
    }
}
