package com.walking.lesson60_thread.task2;

import com.walking.lesson60_thread.task2.service.IntRandomGenerator;
import com.walking.lesson60_thread.task2.service.SingleThreadArrayFillingService;
import com.walking.lesson60_thread.task2.service.ThreadByChunkArrayFillingService;
import com.walking.lesson60_thread.task2.service.ThreadByRowArrayFillingService;

/**
 * Опишите интерфейс, декларирующий метод, заполняющий двумерный массив заданных размеров
 * случайными числами от 1 до 10.
 * Создайте три реализации данного интерфейса:
 * 1. Заполняющую массив в однопоточном режиме;
 * 2. Заполняющую каждый одномерный массив отдельным потоком;
 * 3. Заполняющую каждую секцию каждого одномерного массива отдельным потоком.
 * Оптимальный размер секции рекомендую определить опытным путем или сделать
 * динамически-определяемым в зависимости от размера массива*.
 */
public class Main {
    public static void main(String[] args) {
        var randomGenerator = new IntRandomGenerator(1, 10);

        new SingleThreadArrayFillingService(randomGenerator).fill(new int[10][10000000]);

        new ThreadByRowArrayFillingService(randomGenerator).fill(new int[10][10000000]);

        new ThreadByChunkArrayFillingService(randomGenerator).fill(new int[10][10000000]);
    }
}