package com.walking.lesson60_thread.task2;

import com.walking.lesson60_thread.task2.model.ExtremeMultiThreadTableFiller;
import com.walking.lesson60_thread.task2.model.MultiThreadTableFiller;
import com.walking.lesson60_thread.task2.model.SingleThreadTableFiller;
import com.walking.lesson60_thread.task2.model.TableFiller;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

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
    public static void main(String[] args) throws InterruptedException {
        LocalTime startTime = LocalTime.now();

        Random random = new Random();
        int[][] numbers = new int[10][10_000_000];
        TableFiller tableFiller = new MultiThreadTableFiller();

        tableFiller.fillTable(numbers, () -> random.nextInt(1, 11));

//        print2DArray(numbers);

        LocalTime endTime = LocalTime.now();

        System.out.printf("Overall time = %s\n".formatted(Duration.between(startTime, endTime)
                                                                  .toMillis()));
    }

    public static <T> void print2DArray(int[][] array) {
        for (int[] row : array) {
            for (int column : row) {
                System.out.printf("[%s]".formatted(column));
            }

            System.out.println();
        }
    }
}