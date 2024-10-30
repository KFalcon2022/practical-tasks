package com.walking.lesson64_thread_methods.task2_2;

import java.time.LocalTime;

import com.walking.lesson64_thread_methods.task2_1.Randomizer;

/**
 * Напишите программу, заполняющую двумерный массив большого размера
 * (подберите на свой вкус, ограничения могут зависеть от заданного размера хипа в JVM)
 * случайными числами. Параллельно должен работать поток,
 * каждые 100 миллисекунд пишущий в консоль текущее время.
 * <p>
 * Программа должна завершиться, как только массив будет заполнен.
 * Предоставьте три различных решения данной программы. (Второе)
 */
public class Main {
    public static void main(String[] args) {
            Runnable task=()->{
            try {
                while (true) {
                    System.out.println(LocalTime.now());
                    Thread.sleep(100);       
                }
            } catch (InterruptedException e) {
                return;
            }
        };

        Thread watch=new Thread(task);
        watch.start();
        fillArray(1000, 200000);
        watch.interrupt();

    }

    private static void fillArray(int rows, int cols){
        int[][] arr=new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j]=Randomizer.getNumber(100);
            }
        }
    }
}