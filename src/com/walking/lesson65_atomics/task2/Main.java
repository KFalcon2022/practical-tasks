package com.walking.lesson65_atomics.task2;

import com.walking.lesson65_atomics.task2.service.ArraySearchingService;
import com.walking.lesson65_atomics.task2.service.ArrayFillingService;
import com.walking.lesson65_atomics.task2.service.IntRandomGenerate;

/**
 * Реализуйте метод, возвращающий число элементов равных N в двумерном массиве целых чисел.
 * Массив и N должны передаваться как параметры метода.
 * <p>
 * Каждый одномерный массив должен быть обработан в своем потоке.
 */
public class Main {
    public static void main(String[] args) {
        IntRandomGenerate intRandomGenerate = new IntRandomGenerate(1, 99);
        ArrayFillingService arrayFillingService = new ArrayFillingService(intRandomGenerate);
        ArraySearchingService arraySearchingService = new ArraySearchingService(arrayFillingService
                .fill(new int[100][1000]));

        System.out.println(arraySearchingService.search(1));
    }
}