package com.walking.lesson60_thread.Task2;

public class Main {
    public static void main (String[] args){
        long tm1 = System.currentTimeMillis();
        MyArray1 array1 = new MyArray1(10, 500);
        long tm2 = System.currentTimeMillis();
        System.out.println("Process start: %d, end: %d, diff: %d".formatted(tm1, tm2, tm2 - tm1));

        tm1 = System.currentTimeMillis();
        MyArray2 array2 = new MyArray2(10, 500);
        tm2 = System.currentTimeMillis();
        System.out.println("Process start: %d, end: %d, diff: %d".formatted(tm1, tm2, tm2 - tm1));

        for (int i = 0; i < 10; i++)
            System.out.println(array2.data[i][i]);

    }
}
