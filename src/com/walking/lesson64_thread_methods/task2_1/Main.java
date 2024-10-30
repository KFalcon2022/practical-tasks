package com.walking.lesson64_thread_methods.task2_1;

import java.time.LocalTime;

/**
 * Напишите программу, заполняющую двумерный массив большого размера
 * (подберите на свой вкус, ограничения могут зависеть от заданного размера хипа в JVM)
 * случайными числами. Параллельно должен работать поток,
 * каждые 100 миллисекунд пишущий в консоль текущее время.
 * <p>
 * Программа должна завершиться, как только массив будет заполнен.
 * Предоставьте три различных решения данной программы. (Первое)
 */
public class Main {
    public static void main(String[] args) {
        Runnable task=()->{
            while (true) {
                System.out.println(LocalTime.now());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };

        Thread watch=new Thread(task);
        watch.setDaemon(true);
        watch.start();
        fillArray(1000, 200000);

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