package com.walking.lesson60_thread.task2;

import com.walking.lesson60_thread.task2.model.IntRandomGenerate;
import com.walking.lesson60_thread.task2.model.OneThreadArraysFill;
import com.walking.lesson60_thread.task2.model.OneThreadOneArrayFill;
import com.walking.lesson60_thread.task2.model.ThreadByChunkArrayFilling;

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
        IntRandomGenerate intRandomGenerate = new IntRandomGenerate(1, 9);

        new OneThreadArraysFill(intRandomGenerate).fill(new int[10][10]);
        new OneThreadOneArrayFill(intRandomGenerate).fill(new int[1000][1000]);
        new ThreadByChunkArrayFilling(intRandomGenerate).fill(new int[10000][100000]);

    }
}