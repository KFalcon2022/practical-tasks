package com.walking.lesson60_thread.task2;

import com.walking.lesson60_thread.task2.service.SingleThread;
import com.walking.lesson60_thread.task2.service.ThreadBySection;
import com.walking.lesson60_thread.task2.service.ThreadByWidth;
import com.walking.lesson60_thread.task2.util.AnotherThreadResult;

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
        final int width=2;
        final int length=1000;
        long  stResult;
        long tbwResult;
        long tbsResult;
        AnotherThreadResult<int[][]> atr=new AnotherThreadResult<>();

        long ms=System.currentTimeMillis();
        atr.getResult(()->new SingleThread().fillArray(width, length));
        stResult=System.currentTimeMillis()-ms;
        
        ms=System.currentTimeMillis();
        atr.getResult(()->new ThreadByWidth().fillArray(width, length));
        tbwResult=System.currentTimeMillis()-ms;

        ms=System.currentTimeMillis();
        atr.getResult(()->new ThreadBySection(100).fillArray(width, length));
        tbsResult=System.currentTimeMillis()-ms;

        System.out.println("Результат однопоточника:"+stResult);
        System.out.println("Результат потока на строку:"+tbwResult);
        System.out.println("Результат потока на секцию:"+tbsResult);
    }
}