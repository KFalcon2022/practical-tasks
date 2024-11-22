package com.walking.lesson77_future.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Stream;

/**
 * Реализуйте Задачу 2 урока 73. Не используйте барьер.
 * @see com.walking.lesson73_barrier.task2.Main
 */
/**
 * Реализуйте метод подсчета числа четных элементов в трехмерном массиве.
 * Распараллельте данный процесс.
 */
public class Main {
    public static void main(String[] args) {
        Integer[][][] array=initRandomArray();
        LongAdder counter=new LongAdder();
        List<CompletableFuture<Void>> tasks= new ArrayList<>();

        Stream.of(array).flatMap(arr->Stream.of(arr)).flatMap(arr->Stream.of(arr))
        .map((number)->number%2==0).forEach((condition)->
        tasks.add(CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName());
            if (condition) {counter.increment();}
        })));

        CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0])).join();
        System.out.println(counter.sum());
    }
    public static Integer[][][] initRandomArray(){
        // Создаем трехмерный массив размером 5x5x5
        Integer[][][] array = new Integer[5][5][5];
        
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

    public static Integer[][][] initArray() {
        // Создаем трехмерный массив размером 5x5x5
        Integer[][][] array = {//51
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