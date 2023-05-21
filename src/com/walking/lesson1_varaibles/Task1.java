package com.walking.lesson1_varaibles;

/**
 * На месте комментария написать код, который присвоит переменной a значение переменной b и наоборот.
 * Подсказка: можно использовать третью переменную.
 */
public class Task1 {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        int temp = a;
        a = b;
        b = temp;
        System.out.println("Значение а: " + a + ". Значение b: " + b);
    }
}
