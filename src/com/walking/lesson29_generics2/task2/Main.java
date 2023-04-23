package Lesson29.Task2;

import Lesson29.Task1.WildcardGenericExample;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PowGen<?> powGen = getPowGen(6, 3);
        System.out.println(powGen.pow());
    }
    public static PowGen<? extends Number> getPowGen(Number a, Number b) {
        return new PowGen<>(a, b);
    }
}