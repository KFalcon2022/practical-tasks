package com.walking.lesson77_future.task2;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * Реализуйте параллельный поиск максимального значения в массиве чисел.
 */
public class Main {
    public static void main(String[] args) {
        Integer[] array={2,1,53,12,75,13,96,43,24,15,
            63,24,74,24,46,97,81,3,47,59,6,7,21,65,74,8,52,36,48};

        CompletableFuture<Integer> future=CompletableFuture.supplyAsync(
            new Divider(array)
        );
        System.out.println(future.join());
    }
}
class Divider implements Supplier<Integer> {
    private Integer[] array;
    public Divider(Integer[] array){
        this.array=array;
    }
    @Override
    public Integer get() {
        if (array.length<=2) {
            
            if (array.length==2) {
                System.out.println(Thread.currentThread().getName()+" Дно"+array[0]+"-"+array[1]);
                return (array[0]>array[1])?array[0]:array[1];
            }
            System.out.println(Thread.currentThread().getName()+" Дно"+array[0]);
            return array[0];
        }
        System.out.println(Thread.currentThread().getName()+" Делю");
        Integer left=CompletableFuture.supplyAsync(new Divider(Arrays.copyOfRange(array, 0, array.length/2))).join();
        Integer right=CompletableFuture.supplyAsync(new Divider(Arrays.copyOfRange(array, array.length/2, array.length))).join();
        System.out.println(Thread.currentThread().getName()+" Дно"+left+"-"+right);
        return (left>right)?left:right;
    }

    
}
