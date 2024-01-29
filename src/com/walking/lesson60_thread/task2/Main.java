package com.walking.lesson60_thread.task2;

import com.walking.lesson60_thread.task2.service.*;

import java.util.List;

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
        IntRandomGenerator randomGenerator = new IntRandomGenerator(1,11);
        int[][] arrayForTest = new int[100][1000000];

        SingleThreadArrayFillingService arraySingle = new SingleThreadArrayFillingService(randomGenerator);
        ThreadByRowArrayFillingService arrayThreadRow = new ThreadByRowArrayFillingService(randomGenerator);

        ArrayFillingSpeedService.checkSpeed(arraySingle,arrayForTest);
        ArrayFillingSpeedService.checkSpeed(arrayThreadRow,arrayForTest);

        ThreadBySectionArrayFillingService arrayThreadSection = new ThreadBySectionArrayFillingService(randomGenerator);
        ArrayFillingSpeedService.checkSpeed(arrayThreadSection,arrayForTest);
    }
}