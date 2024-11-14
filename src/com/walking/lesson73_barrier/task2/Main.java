package com.walking.lesson73_barrier.task2;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.LongAdder;

import com.walking.lesson73_barrier.task2.model.EvenSummer;

/**
 * Реализуйте метод подсчета числа четных элементов в трехмерном массиве.
 * Распараллельте данный процесс.
 */
public class Main {
    public static void main(String[] args) {
        int[][][] array=initRandomArray();
        LongAdder counter=new LongAdder();
        AtomicBoolean done=new AtomicBoolean(false);
        CyclicBarrier barrier=new CyclicBarrier(array.length, ()->{done.set(true);});
        for (int[][] doubleArray : array) {
            Thread t=new Thread(new EvenSummer(doubleArray, counter, barrier));
            t.start();
            
        }
        while (!done.get()) {

        }
        System.out.println(counter.sum());
    }

    public static int[][][] initRandomArray(){
        // Создаем трехмерный массив размером 5x5x5
        int[][][] array = new int[5][5][5];
        
        // Заполняем массив случайными числами от 0 до 99
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    array[i][j][k] = (int) (Math.random() * 100);
                }
            }
        }
        
        return array;
    }

    public static int[][][] initArray() {
        // Создаем трехмерный массив размером 5x5x5
        int[][][] array = {//51
            {
                {10, 20, 30, 40, 50},//5
                {60, 70, 80, 90, 100},//5
                {25, 75, 84, 92, 101},//2
                {69, 77, 85, 91, 200},//1
                {12, 14, 13, 15, 10}//3
            },//16
            {
                {10, 20, 30, 40, 50},//5
                {60, 70, 80, 90, 100},//5
                {10, 20, 30, 40, 50},//5
                {60, 70, 80, 90, 100},//5
                {10, 20, 30, 40, 50}//5
            },//25
            {
                {11, 21, 33, 45, 51},//0
                {11, 21, 33, 45, 51},//0
                {11, 21, 33, 45, 51},//0
                {69, 77, 85, 91, 200},//1
                {11, 13, 15, 17, 19}//0
            },//1
            {
                {11, 21, 33, 45, 51},//0
                {11, 21, 33, 45, 51},//0
                {11, 21, 33, 45, 51},//0
                {69, 77, 85, 91, 200},//1
                {12, 14, 13, 15, 10}//3
            },//4
            {
                {25, 75, 84, 92, 101},//2
                {11, 21, 33, 45, 51},//0
                {11, 21, 33, 45, 51},//0
                {11, 21, 33, 45, 51},//0
                {12, 14, 13, 15, 10}//3
            }//5
        };
        
        return array;
    }
}