package com.walking.lesson1_varaibles;

/**
 * На месте комментария написать код, который присвоит переменной a значение переменной b и наоборот.
 * Подсказка: можно использовать третью переменную.
 */
public class Task1 {
    public static void main(String[] args) {
        int a = 7;
        int b = 10;
        System.out.println("Было: a = " + a + " , b = " + b);

        int c =  b;
        b = a;
        a = c;
        System.out.println("Стало: a = " + a + " , b = " + b);
    }
}
