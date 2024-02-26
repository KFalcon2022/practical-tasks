package com.walking.lesson65_atomics.task2;

import com.walking.lesson65_atomics.task2.service.EqualNumberCounter;

/**
 * Реализуйте метод, возвращающий число элементов равных N в двумерном массиве целых чисел.
 * Массив и N должны передаваться как параметры метода.
 * <p>
 * Каждый одномерный массив должен быть обработан в своем потоке.
 */
public class Main {
    public static void main(String[] args) {
        EqualNumberCounter equalNumberCounter = new EqualNumberCounter();
        int[][] array = new int[][]{
                {1, 3, 4, 7, 8},
                {2, 3, 1, 0, 1},
                {3, 5, 6, 11, 8}};

        System.out.println(equalNumberCounter.getEqualValueNumber(array, 1));
    }
}