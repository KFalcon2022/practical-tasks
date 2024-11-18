package com.walking.lesson75_thread_pool.task3;

import com.walking.lesson75_thread_pool.task3.service.ThreadBySection;
import com.walking.lesson75_thread_pool.task3.util.AnotherThreadResult;

/**
 * Реализуйте третий вариант Задачи 2 урока 60 с использованием пулов потоков.
 * @see com.walking.lesson60_thread.task2.Main
 */

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
        final int width=1000;
        final int length=1000;
        long tbsResult;
        AnotherThreadResult<int[][]> atr=new AnotherThreadResult<>();

        long ms=System.currentTimeMillis();
        atr.getResult(()->new ThreadBySection(100).fillArray(width, length));
        tbsResult=System.currentTimeMillis()-ms;

        System.out.println("Результат потока на секцию:"+tbsResult);
    }
}