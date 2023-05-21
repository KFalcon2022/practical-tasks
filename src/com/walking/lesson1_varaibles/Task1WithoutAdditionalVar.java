package com.walking.lesson1_varaibles;

/**
 * На месте комментария написать код, который присвоит переменной a значение переменной b и наоборот.
 * Вариант на подумать: реализовать задачу, НЕ используя третью переменную.
 */
public class Task1WithoutAdditionalVar {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("Значение а: " + a + ". Значение b: " + b);
    }
}
