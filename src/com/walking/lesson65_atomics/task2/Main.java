package com.walking.lesson65_atomics.task2;

import java.util.concurrent.atomic.LongAdder;

/**
 * Реализуйте метод, возвращающий число элементов равных N в двумерном массиве целых чисел.
 * Массив и N должны передаваться как параметры метода.
 * <p>
 * Каждый одномерный массив должен быть обработан в своем потоке.
 */
public class Main {
    public static void main(String[] args) {
        int[][] arr=fillArray(10,2000);
        System.out.println(getEqualCount(arr, 9));
    }

    public static int[][] fillArray(int row, int col){
        int[][] arr=new int[row][col];
        for (int j = 0; j < arr.length; j++) {
            final int finalRow=j;
            Thread t=new Thread(()->{
                for (int i = 0; i < arr[finalRow].length; i++) {
                    arr[finalRow][i]=getRandomNumber(10);
                }
            });
            t.start();
        }
        while (Thread.activeCount()>1) {
            
        }
        return arr;
    }

    public static int getRandomNumber(int max){
        int random=(int)Math.round(Math.random()*max);
        return (random==0)?1:random;
    }

    public static long getEqualCount(int[][] arr, int n){
        LongAdder count=new LongAdder();
        for (int j = 0; j < arr.length; j++) {
            final int finalRow=j;
            Thread t=new Thread(()->{
                for (int i = 0; i < arr[finalRow].length; i++) {
                    if (arr[finalRow][i]==n) {
                        count.increment();
                    }
                }
            });
            t.start();
        }
        return count.sum();
    }
}